package com.keqi.apihu.pj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.apihu.core.common.Auth;
import com.keqi.apihu.pj.domain.ApiParamType;
import com.keqi.apihu.pj.domain.db.ApiRequestDO;
import com.keqi.apihu.pj.domain.db.ApiRequestParamDO;
import com.keqi.apihu.pj.domain.param.CreateApiRequestParam;
import com.keqi.apihu.pj.domain.param.CreateApiRequestParamParam;
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

    @Override
    public int deleteByPrimaryKey(Long id) {
        return apiRequestMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ApiRequestDO record) {
        return apiRequestMapper.insert(record);
    }

    @Override
    public int insertSelective(ApiRequestDO record) {
        return apiRequestMapper.insertSelective(record);
    }

    @Override
    public ApiRequestDO selectByPrimaryKey(Long id) {
        return apiRequestMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ApiRequestDO record) {
        return apiRequestMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ApiRequestDO record) {
        return apiRequestMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<ApiRequestDO> list) {
        return apiRequestMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<ApiRequestDO> list) {
        return apiRequestMapper.batchInsert(list);
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
        apiRequestDO.setProjectid(Auth.getProjectId());
        BeanUtil.copyProperties(createApiRequestParam, apiRequestDO);
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