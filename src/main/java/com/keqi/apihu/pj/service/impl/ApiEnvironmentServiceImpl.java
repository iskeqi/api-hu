package com.keqi.apihu.pj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.apihu.core.common.Auth;
import com.keqi.apihu.pj.domain.db.ApiEnvironmentDO;
import com.keqi.apihu.pj.domain.db.ApiEnvironmentParamDO;
import com.keqi.apihu.pj.domain.param.CreateApiEnvironmentParam;
import com.keqi.apihu.pj.domain.param.CreateApiEnvironmentParamParam;
import com.keqi.apihu.pj.domain.param.UpdateApiEnvironmentParam;
import com.keqi.apihu.pj.domain.param.UpdateApiEnvironmentParamParam;
import com.keqi.apihu.pj.domain.vo.PageApiEnvironmentVO;
import com.keqi.apihu.pj.mapper.ApiEnvironmentMapper;
import com.keqi.apihu.pj.mapper.ApiEnvironmentParamMapper;
import com.keqi.apihu.pj.service.ApiEnvironmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ApiEnvironmentServiceImpl implements ApiEnvironmentService {

    private final ApiEnvironmentMapper apiEnvironmentMapper;
    private final ApiEnvironmentParamMapper apiEnvironmentParamMapper;

    /**
     * 删除API环境
     *
     * @param id id
     * @return r
     */
    @Override
    @Transactional
    public int deleteByPrimaryKey(Long id) {
        int i = this.apiEnvironmentMapper.deleteByPrimaryKey(id);
        int j = this.apiEnvironmentParamMapper.deleteByApiEnvironmentId(id);
        return i + j;
    }

    /**
     * 修改API环境
     *
     * @param updateApiEnvironmentParam updateApiEnvironmentParam
     * @return r
     */
    @Override
    @Transactional
    public void updateByPrimaryKey(UpdateApiEnvironmentParam updateApiEnvironmentParam) {
        int j = this.deleteByPrimaryKey(updateApiEnvironmentParam.getId());

        if (j > 0) {
            CreateApiEnvironmentParam createApiEnvironmentParam = new CreateApiEnvironmentParam();
            BeanUtil.copyProperties(updateApiEnvironmentParam, createApiEnvironmentParam);

            List<UpdateApiEnvironmentParamParam> list = updateApiEnvironmentParam.getApiEnvironmentParamParamList();
            if (list.size() > 0) {
                List<CreateApiEnvironmentParamParam> l = new ArrayList<>(list.size());
                for (UpdateApiEnvironmentParamParam u : list) {
                    CreateApiEnvironmentParamParam c = new CreateApiEnvironmentParamParam();
                    BeanUtil.copyProperties(u, c);
                    l.add(c);
                }
                createApiEnvironmentParam.setApiEnvironmentParamParamList(l);
            }

            this.createApiEnvironment(createApiEnvironmentParam);
        }
    }

    /**
     * 增加API环境
     *
     * @param createApiEnvironmentParam createApiEnvironmentParam
     */
    @Override
    @Transactional
    public void createApiEnvironment(CreateApiEnvironmentParam createApiEnvironmentParam) {
        ApiEnvironmentDO apiEnvironmentDO = new ApiEnvironmentDO();
        BeanUtil.copyProperties(createApiEnvironmentParam, apiEnvironmentDO);
        apiEnvironmentDO.setProjectid(Auth.getProjectId());
        this.apiEnvironmentMapper.insert(apiEnvironmentDO);

        List<CreateApiEnvironmentParamParam> list = createApiEnvironmentParam.getApiEnvironmentParamParamList();
        if (list.size() > 0) {
            List<ApiEnvironmentParamDO> apiEnvironmentParamDOS = new ArrayList<>();
            for (CreateApiEnvironmentParamParam t : list) {
                ApiEnvironmentParamDO apiEnvironmentParamDO = new ApiEnvironmentParamDO();
                BeanUtil.copyProperties(t, apiEnvironmentParamDO);
                apiEnvironmentParamDO.setApiEnvironmentId(apiEnvironmentDO.getId());
                apiEnvironmentParamDOS.add(apiEnvironmentParamDO);
            }
            this.apiEnvironmentParamMapper.batchInsert(apiEnvironmentParamDOS);
        }

    }

    /**
     * 查询全部API环境列表
     *
     * @return r
     */
    @Override
    public List<PageApiEnvironmentVO> listApiEnvironment() {
        return this.apiEnvironmentMapper.findAll(Auth.getProjectId());
    }

}
