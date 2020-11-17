package com.keqi.apihu.pj.service;

import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.manage.domain.vo.PageProjectVO;
import com.keqi.apihu.pj.domain.param.CreateDatasourceParam;
import com.keqi.apihu.pj.domain.param.QueryDatasourceParam;
import com.keqi.apihu.pj.domain.param.UpdateDatasourceParam;
import com.keqi.apihu.pj.domain.vo.PageDatasourceTableColumnVO;
import com.keqi.apihu.pj.domain.vo.PageDatasourceTableVO;
import com.keqi.apihu.pj.domain.vo.PageDatasourceVO;

public interface DatasourceService {

    /**
     * 根据id删除数据源
     *
     * @param id id
     * @return r
     */
    void deleteByPrimaryKey(Long id);

    /**
     * 修改数据源
     *
     * @param updateDatasourceParam updateDatasourceParam
     * @return r
     */
    void updateByPrimaryKey(UpdateDatasourceParam updateDatasourceParam);

    /**
     * 增加数据源
     *
     * @param createProjectParam createProjectParam
     */
    void createDataSource(CreateDatasourceParam createProjectParam);

    /**
     * 分页查询数据源列表
     *
     * @param queryDatasourceParam queryDatasourceParam
     * @return r
     */
    AjaxPageEntity<PageProjectVO> pageDataSource(QueryDatasourceParam queryDatasourceParam);

    /**
     * 在线读取数据库
     *
     * @param id id
     */
    void readDataSource(Long id);

    /**
     * 查询全部数据源列表
     *
     * @param queryDatasourceParam queryDatasourceParam
     * @return r
     */
    AjaxPageEntity<PageDatasourceVO> listDataSource(QueryDatasourceParam queryDatasourceParam);

    /**
     * 查询指定数据源下的所有表
     *
     * @param id id
     * @return r
     */
    AjaxPageEntity<PageDatasourceTableVO> listByDatasourceId(Long id);

    /**
     * 查询指定表下的所有列
     *
     * @param id id
     * @return r
     */
    AjaxPageEntity<PageDatasourceTableColumnVO> listByDatasourceTableId(Long id);
}
