package com.keqi.apihu.manage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.manage.service.DictItemService;
import com.keqi.apihu.manage.domain.db.DictItemDO;
import com.keqi.apihu.manage.domain.param.CreateDictItemParam;
import com.keqi.apihu.manage.domain.param.UpdateDictItemParam;
import com.keqi.apihu.manage.domain.vo.DictItemVO;
import com.keqi.apihu.manage.mapper.DictItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class DictItemServiceImpl implements DictItemService {

    private final DictItemMapper dictItemMapper;

    /**
     * 删除字典项（物理删除）
     * @param id id
     * @return r
     */
    @Override
    @Transactional
    public void deleteByPrimaryKey(Long id) {
        dictItemMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改字典项
     *
     * @param updateDictItemParam updateDictItemParam
     */
    @Override
    @Transactional
    public void updateByPrimaryKey(UpdateDictItemParam updateDictItemParam) {
        DictItemDO temp = this.dictItemMapper.findOneByTypeCodeAndItemCode(updateDictItemParam.getTypeCode(),
                updateDictItemParam.getItemCode());
        if (temp != null && Objects.equals(temp.getId(), updateDictItemParam.getId())) {
            throw new BusinessException("存在同名 itemCode ");
        }
        DictItemDO dictItemDO = new DictItemDO();
        BeanUtil.copyProperties(updateDictItemParam, dictItemDO);
        this.dictItemMapper.updateByPrimaryKey(dictItemDO);
    }

    /**
     * 增加字典项
     *
     * @param createDictItemParam createDictItemParam
     */
    @Override
    @Transactional
    public void createItem(CreateDictItemParam createDictItemParam) {
        int count = this.dictItemMapper.itemCodeExist(createDictItemParam.getTypeCode(),
                createDictItemParam.getItemCode());
        if (count > 0) {
            throw new BusinessException("存在同名 itemCode ");
        }

        DictItemDO dictItemDO = new DictItemDO();
        BeanUtil.copyProperties(createDictItemParam, dictItemDO);
        this.dictItemMapper.insert(dictItemDO);
    }

    /**
     * 查询指定字典类型下的全部列表
     *
     * @param typeCode typeCode
     */
    @Override
    public AjaxPageEntity<DictItemVO> pageDictItem(String typeCode) {
        List<DictItemVO> dictItemVOList = this.dictItemMapper.findAllByTypeCode(typeCode);

        AjaxPageEntity<DictItemVO> ajaxPageEntity = new AjaxPageEntity<>();
        ajaxPageEntity.setTotal(dictItemVOList.size());
        ajaxPageEntity.setList(dictItemVOList);
        return ajaxPageEntity;
    }

    //================================私有方法================================//


}
