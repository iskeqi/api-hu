package com.keqi.apihu.pj.service;

import com.keqi.apihu.pj.domain.param.CreateApiEnvironmentParam;
import com.keqi.apihu.pj.domain.param.UpdateApiEnvironmentParam;
import com.keqi.apihu.pj.domain.vo.PageApiEnvironmentVO;

import java.util.List;

public interface ApiEnvironmentService {

    /**
     * 删除API环境
     * @param id id
     * @return r
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 修改API环境
     * @param updateApiEnvironmentParam updateApiEnvironmentParam
     * @return r
     */
    void updateByPrimaryKey(UpdateApiEnvironmentParam updateApiEnvironmentParam);

    /**
     * 增加API环境
     * @param createApiEnvironmentParam createApiEnvironmentParam
     */
    void createApiEnvironment(CreateApiEnvironmentParam createApiEnvironmentParam);

    /**
     * 查询全部API环境列表
     * @return r
     */
    List<PageApiEnvironmentVO> listApiEnvironment();

}
