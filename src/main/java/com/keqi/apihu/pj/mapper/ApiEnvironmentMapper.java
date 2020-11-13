package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.db.ApiEnvironmentDO;
import com.keqi.apihu.pj.domain.vo.PageApiEnvironmentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiEnvironmentMapper {

    /**
     * 根据主键删除
     *
     * @param id id
     * @return r
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 增加API环境
     *
     * @param record record
     * @return r
     */
    int insert(ApiEnvironmentDO record);

    int insertSelective(ApiEnvironmentDO record);

    ApiEnvironmentDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiEnvironmentDO record);

    int updateByPrimaryKey(ApiEnvironmentDO record);

    int updateBatch(List<ApiEnvironmentDO> list);

    int batchInsert(@Param("list") List<ApiEnvironmentDO> list);

    /**
     * 查询全部API环境及其关联的环境参数
     * @param projectId projectId
     * @return r
     */
    List<PageApiEnvironmentVO> findAll(@Param("projectId") Long projectId);


}