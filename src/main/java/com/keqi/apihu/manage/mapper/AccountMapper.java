package com.keqi.apihu.manage.mapper;

import com.keqi.apihu.manage.domain.AccountDO;
import com.keqi.apihu.manage.domain.param.AccountListParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountDO record);

    int insertSelective(AccountDO record);

    AccountDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountDO record);

    int updateByPrimaryKey(AccountDO record);

    void batchDelete(@Param("ids") Long[] ids);

    long count(AccountListParam accountListParam);

    List<AccountDO> listAccount(AccountListParam accountListParam);
}