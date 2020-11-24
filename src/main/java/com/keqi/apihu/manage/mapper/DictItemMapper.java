package com.keqi.apihu.manage.mapper;

import com.keqi.apihu.manage.domain.db.DictItemDO;
import com.keqi.apihu.manage.domain.vo.DictItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictItemMapper {

    /**
     * 删除字典项（物理删除）
     *
     * @param id id
     */
    void deleteByPrimaryKey(Long id);

    /**
     * 增加字典项
     *
     * @param record record
     */
    void insert(DictItemDO record);

    /**
     * 修改字典项
     *
     * @param record record
     */
    void updateByPrimaryKey(DictItemDO record);

    /**
     * 查询是否存在 itemCode
     *
     * @param itemCode itemCode
     * @param typeCode typeCode
     * @return r
     */
    int itemCodeExist(@Param("typeCode") String typeCode, @Param("itemCode") String itemCode);

    /**
     * 查询指定字典类型下的全部列表
     *
     * @param typeCode typeCode
     * @return r
     */
    List<DictItemVO> findAllByTypeCode(String typeCode);

    /**
     * 根据 typeCode 和 itemCode 查找字典项
     *
     * @param typeCode typeCode
     * @param itemCode itemCode
     * @return r
     */
    DictItemDO findOneByTypeCodeAndItemCode(@Param("typeCode") String typeCode, @Param("itemCode") String itemCode);

    /**
     * 查询字典表中所有的 typeCode 列表
     *
     * @return r
     */
    List<String> listTypeCode();


}