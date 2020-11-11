package com.keqi.apihu.pj.service;

import com.keqi.apihu.pj.domain.db.DatasourceDO;
import com.keqi.apihu.pj.domain.param.CreateDatasourceParam;

public interface DatasourceService{


    int deleteByPrimaryKey(Long id);

    int insert(DatasourceDO record);

    int insertSelective(DatasourceDO record);

    DatasourceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DatasourceDO record);

    int updateByPrimaryKey(DatasourceDO record);

    /**
     * 增加数据源
     * @param createProjectParam createProjectParam
     */
    void createDataSource(CreateDatasourceParam createProjectParam);
}
