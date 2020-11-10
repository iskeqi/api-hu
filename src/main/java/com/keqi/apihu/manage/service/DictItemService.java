package com.keqi.apihu.manage.service;

import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.manage.domain.param.CreateDictItemParam;
import com.keqi.apihu.manage.domain.param.UpdateDictItemParam;
import com.keqi.apihu.manage.domain.vo.DictItemVO;

public interface DictItemService{

    /**
     * 删除字典项（物理删除）
     * @param id id
     */
    void deleteByPrimaryKey(Long id);

    /**
     * 修改字典项
     * @param updateDictItemParam updateDictItemParam
     */
    void updateByPrimaryKey(UpdateDictItemParam updateDictItemParam);

    /**
     * 增加字典项
     * @param createDictItemParam createDictItemParam
     */
    void createItem(CreateDictItemParam createDictItemParam);

    /**
     * 查询指定字典类型下的全部列表
     * @param typeCode typeCode
     */
    AjaxPageEntity<DictItemVO> pageDictItem(String typeCode);
}
