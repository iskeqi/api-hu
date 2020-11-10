package com.keqi.apihu.manage.mapper;

import com.keqi.apihu.manage.domain.db.DictItemDO;
import com.keqi.apihu.manage.domain.vo.DictItemVO;

import java.util.List;

public interface DictItemMapper {

    /**
     * 删除字典项（物理删除）
     * @param id id
     */
    void deleteByPrimaryKey(Long id);

    /**
     * 增加字典项
     * @param record record
     */
    void insert(DictItemDO record);

    /**
     * 修改字典项
     * @param record record
     */
    void updateByPrimaryKey(DictItemDO record);

    /**
     * 查询是否存在 itemCode
     * @param itemCode itemCode
     * @return r
     */
    int itemCodeExist(String itemCode);

    /**
     * 查询指定字典类型下的全部列表
     * @param typeCode typeCode
     * @return r
     */
    List<DictItemVO> findAllByTypeCode(String typeCode);
}