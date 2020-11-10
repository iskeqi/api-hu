package com.keqi.apihu.manage.mapper;

import com.keqi.apihu.manage.domain.db.AccountProjectDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountProjectMapper {
    int deleteByPrimaryKey(@Param("accountId") Long accountId, @Param("projectId") Long projectId);

    int insert(AccountProjectDO record);

    /**
     * 批量增加记录
     * @param list list
     * @return r
     */
    int batchInsert(@Param("list") List<AccountProjectDO> list);

    /**
     * 删除指定项目ID关联的人员列表
     * @param projectId projectId
     */
    void deleteByProjectId(Long projectId);
}