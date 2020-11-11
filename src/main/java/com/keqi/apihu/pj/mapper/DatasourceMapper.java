package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.db.DatasourceDO;
import com.keqi.apihu.pj.domain.param.QueryDatasourceParam;
import com.keqi.apihu.pj.domain.vo.PageDatasourceVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DatasourceMapper {

    /**
     * 根据 id 删除数据源
     * @param id id
     * @return r
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 增加数据源
     * @param record record
     * @return r
     */
    void insert(DatasourceDO record);

    int insertSelective(DatasourceDO record);

    /**
     * 根据Id获取表结构信息
     * @param id id
     * @return r
     */
    DatasourceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DatasourceDO record);

    /**
     * 修改数据源
     * @param record record
     */
    void updateByPrimaryKey(DatasourceDO record);

    /**
     * 判断同名数据源是否存在
     * @param name name
     * @param projectId projectId
     * @return r
     */
    int dataSourceExist(@Param("name") String name, @Param("projectId") Long projectId);

    /**
     * 分页查询数据源总记录数
     * @param queryDatasourceParam queryProjectParam
     * @return r
     */
    int countDataSource(QueryDatasourceParam queryDatasourceParam);

    /**
     * 分页查询数据源列表
     * @param queryDatasourceParam queryDatasourceParam
     * @return r
     */
    List<PageDatasourceVO> pageDataSource(QueryDatasourceParam queryDatasourceParam);

    /**
     * 通过 name 和 projectid 查询数据源对象
     * @param name name
     * @param projectid projectid
     * @return
     */
    DatasourceDO findOneByNameAndProjectid(@Param("name")String name,@Param("projectid")Long projectid);


}