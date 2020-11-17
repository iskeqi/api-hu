package com.keqi.apihu.pj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.core.common.Auth;
import com.keqi.apihu.pj.domain.ApiParamType;
import com.keqi.apihu.pj.domain.Direction;
import com.keqi.apihu.pj.domain.PjConstant;
import com.keqi.apihu.pj.domain.db.ApiRequestDO;
import com.keqi.apihu.pj.domain.db.ApiRequestParamDO;
import com.keqi.apihu.pj.domain.param.CreateApiRequestParam;
import com.keqi.apihu.pj.domain.param.CreateApiRequestParamParam;
import com.keqi.apihu.pj.domain.param.QueryApiRequestParam;
import com.keqi.apihu.pj.domain.vo.ApiRequestDetailVO;
import com.keqi.apihu.pj.domain.vo.ApiRequestParamVO;
import com.keqi.apihu.pj.domain.vo.PageApiRequestVO;
import com.keqi.apihu.pj.mapper.ApiRequestMapper;
import com.keqi.apihu.pj.mapper.ApiRequestParamMapper;
import com.keqi.apihu.pj.service.ApiRequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@AllArgsConstructor
public class ApiRequestServiceImpl implements ApiRequestService {

    private final ApiRequestMapper apiRequestMapper;
    private final ApiRequestParamMapper apiRequestParamMapper;

    /**
     * 删除API
     * @param id id
     * @return r
     */
    @Override
    @Transactional
    public int deleteByPrimaryKey(Long id) {
        int i = this.apiRequestMapper.deleteByPrimaryKey(id);
        int j = this.apiRequestParamMapper.deleteByApiRequestId(id);
        return i + j;
    }

    /**
     * 查询API详情
     * @param id id
     * @return r
     */
    @Override
    public ApiRequestDetailVO selectByPrimaryKey(Long id) {
        ApiRequestDetailVO detail = new ApiRequestDetailVO();

        // API参数
        ApiRequestDO apiRequestDO = this.apiRequestMapper.selectByPrimaryKey(id);
        BeanUtil.copyProperties(apiRequestDO, detail);

        // API 请求参数
        List<ApiRequestParamVO> requestList = this.apiRequestParamMapper.
                findAllByApiRequestIdAndParamType(id, ApiParamType.REQUEST.name());
        List<ApiRequestParamVO> requests = this.assembleTreeList(requestList, PjConstant.rootParentId);
        detail.setRequestParamList(requests);

        // API 响应参数
        List<ApiRequestParamVO> responseList = this.apiRequestParamMapper.
                findAllByApiRequestIdAndParamType(id, ApiParamType.RESPONSE.name());
        List<ApiRequestParamVO> responses = this.assembleTreeList(responseList, PjConstant.rootParentId);
        detail.setResponseParamList(responses);

        return detail;
    }

    /**
     * 修改API
     * @param updateApiRequestParam updateApiRequestParam
     * @return r
     */
    @Override
    @Transactional
    public void updateByPrimaryKey(CreateApiRequestParam updateApiRequestParam) {
        int i = this.deleteByPrimaryKey(updateApiRequestParam.getId());
        if (i > 0) {
            this.createApiRequest(updateApiRequestParam);
        }
    }

    /**
     * 增加API
     *
     * @param createApiRequestParam createApiRequestParam
     */
    @Override
    @Transactional
    public void createApiRequest(CreateApiRequestParam createApiRequestParam) {
        ApiRequestDO apiRequestDO = new ApiRequestDO();
        apiRequestDO.setProjectId(Auth.getProjectId());
        BeanUtil.copyProperties(createApiRequestParam, apiRequestDO);
        // 获取 orderNum 字段
        Integer max = this.apiRequestMapper.getMaxOrderNumByApiGroupId(createApiRequestParam.getApiGroupId());
        apiRequestDO.setOrderNum(max + 1);
        this.apiRequestMapper.insert(apiRequestDO);

        // 请求参数
        List<CreateApiRequestParamParam> requestParamList = createApiRequestParam.getRequestParamList();
        if (requestParamList.size() > 0) {
            this.insertParameters(requestParamList, ApiParamType.REQUEST, apiRequestDO);
        }

        // 响应参数
        List<CreateApiRequestParamParam> responseParamList = createApiRequestParam.getResponseParamList();
        if (responseParamList.size() > 0) {
            this.insertParameters(requestParamList, ApiParamType.RESPONSE, apiRequestDO);
        }
    }

    /**
     * 分页查询API列表
     *
     * @param queryApiRequestParam queryApiRequestParam
     * @return r
     */
    @Override
    public AjaxPageEntity<PageApiRequestVO> pageApiRequest(QueryApiRequestParam queryApiRequestParam) {
        queryApiRequestParam.setProjectId(Auth.getProjectId());

        // 只查询该分组下的API，子级的 API 不展示出来


        int total = this.apiRequestMapper.countByName(queryApiRequestParam);

        AjaxPageEntity ajaxPageEntity = new AjaxPageEntity();

        if (total > 0) {
            List<PageApiRequestVO> pageAccountVOList = this.apiRequestMapper.pageApiRequest(queryApiRequestParam);
            ajaxPageEntity.setTotal(total);
            ajaxPageEntity.setList(pageAccountVOList);
        }

        return ajaxPageEntity;
    }

    /**
     * 在本级移动API(本质就是两个API互相交换位置)
     *
     * @param id        id
     * @param direction direction
     */
    @Override
    public void moveApi(Long id, Direction direction) {
        ApiRequestDO apiRequestDO = this.apiRequestMapper.selectByPrimaryKey(id);

        if (apiRequestDO != null) {
            int orderNum = apiRequestDO.getOrderNum();
            int max = this.apiRequestMapper.getMaxOrderNumByApiGroupId(apiRequestDO.getApiGroupId());
            int min = this.apiRequestMapper.getMinOrderNumByApiGroupId(apiRequestDO.getApiGroupId());

            ApiRequestDO previous = this.apiRequestMapper.findPreviousByApiGroupId(apiRequestDO.getApiGroupId(), orderNum);
            ApiRequestDO next = this.apiRequestMapper.findNextByApiGroupId(apiRequestDO.getApiGroupId(), orderNum);

            if (Direction.DOWN.equals(direction) && (orderNum == min || (orderNum > min && orderNum < max))) {
                // 自己 +1,下一个 -1
                this.apiRequestMapper.updateOrderNumById(orderNum + 1, id);
                this.apiRequestMapper.updateOrderNumById(next.getOrderNum() - 1, next.getId());
            } else if ((orderNum == max && Direction.UP.equals(direction)) ||
                    ((orderNum > min && orderNum < max) && Direction.UP.equals(direction))) {
                // 自己 -1，上一个 +1
                this.apiRequestMapper.updateOrderNumById(orderNum - 1, id);
                this.apiRequestMapper.updateOrderNumById(previous.getOrderNum() + 1, previous.getId());
            } // 不用动

        }
    }

    /**
     * 移动API到其他分组下
     *
     * @param id         id
     * @param apiGroupId apiGroupId
     */
    @Override
    @Transactional
    public void moveApiToOtherGroup(Long id, Long apiGroupId) {
        Integer max = this.apiRequestMapper.getMaxOrderNumByApiGroupId(apiGroupId);
        this.apiRequestMapper.updateApiGroupIdAndOrderNumById(apiGroupId, max + 1, id);
    }

    //================================私有方法================================//

    /**
     * 使用 BFS 遍历树形结构，并插入数据到对应的表中
     * @param requestParamParamList requestParamParamList
     * @param apiParamType apiParamType
     * @param apiRequestDO apiRequestDO
     */
    private void insertParameters(List<CreateApiRequestParamParam> requestParamParamList, ApiParamType apiParamType, ApiRequestDO apiRequestDO) {
        CreateApiRequestParamParam root = new CreateApiRequestParamParam();
        root.setId((long)0);
        root.setSubList(requestParamParamList);

        Queue<CreateApiRequestParamParam> queue = new LinkedList<>();
        queue.offer(root);
        Map<CreateApiRequestParamParam, CreateApiRequestParamParam> map = new HashMap<>();
        while (!queue.isEmpty()) {
            CreateApiRequestParamParam c;
            for (int i = 0; i < queue.size(); i++) {
                c = queue.poll();

                if (!Objects.equals(c.getId(), (long)0)) {
                    // 插入记录
                    ApiRequestParamDO apiRequestParamDO = new ApiRequestParamDO();
                    BeanUtil.copyProperties(c, apiRequestParamDO);
                    this.apiRequestParamMapper.insert(apiRequestParamDO);
                    c.setId(apiRequestParamDO.getId());
                }

                List<CreateApiRequestParamParam> list = c.getSubList();
                if (!Objects.isNull(list)) {
                    for (int j = 0; j < list.size(); j++) {
                        CreateApiRequestParamParam ca = list.get(j);
                        map.put(ca, c);
                        ca.setParentId(map.get(ca).getId());
                        ca.setParamType(apiParamType.name());
                        ca.setApiRequestId(apiRequestDO.getId());
                        ca.setOrderNum(j + 1);
                        queue.offer(ca);
                    }
                }
            }
        }
    }

    /**
     * 把没有层次结构的分组列表按照父子结构关系进行组装（递归构造树形结构）
     * @param list list
     * @return r
     */
    private List<ApiRequestParamVO> assembleTreeList(List<ApiRequestParamVO> list, Long rootParentId) {
        List<ApiRequestParamVO> treeList = new ArrayList<>();
        for (ApiRequestParamVO obj : list) {
            if (obj.getParentId().equals(rootParentId)) {
                obj.setSubList(assembleTreeList(list, obj.getId()));
                treeList.add(obj);
            }
        }
        treeList.sort(Comparator.comparing(ApiRequestParamVO::getOrderNum));
        return treeList;
    }
}
