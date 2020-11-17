package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.db.ApiGroupDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiGroupMapper {

    /**
     * 删除API分组
     *
     * @param id id
     * @return r
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 增加API分组
     *
     * @param record record
     * @return r
     */
    int insert(ApiGroupDO record);

    int insertSelective(ApiGroupDO record);

    ApiGroupDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiGroupDO record);

    int updateByPrimaryKey(ApiGroupDO record);

    int updateBatch(List<ApiGroupDO> list);

    /**
     * 批量新增分组
     *
     * @param list list
     * @return r
     */
    int batchInsert(@Param("list") List<ApiGroupDO> list);

    /**
     * 根据 parentId 查找下级最大 orderNum
     *
     * @param apiGroupDO apiGroupDO
     * @return r
     */
    int getMaxOrderNumByParentId(ApiGroupDO apiGroupDO);

    /**
     * 根据 parentId 查询记录总数
     *
     * @param parentId parentId
     * @return r
     */
    int countByParentId(@Param("parentId") Long parentId);

    /**
     * 根据 id 修改 name
     *
     * @param apiGroupDO apiGroupDO
     */
    void updateNameById(ApiGroupDO apiGroupDO);

    /**
     * 根据 name 查询分组
     *
     * @param name name
     * @return r
     */
    ApiGroupDO findOneByName(@Param("name") String name, @Param("projectId") Long projectId);

    /**
     * 查询全部分组列表
     *
     * @param projectId projectId
     * @return r
     */
    List<ApiGroupDO> findAllByProjectId(@Param("projectId") Long projectId);


    /**
     * 查询 parentId 下的所有分组列表
     *
     * @param parentId parentId
     * @return r
     */
    List<ApiGroupDO> findAllByParentId(@Param("parentId") Long parentId);

    /**
     * 删除项目id下的所有分组
     *
     * @param projectId projectId
     * @return r
     */
    int deleteByProjectId(@Param("projectId") Long projectId);


}