package com.keqi.apihu.manage.util;

import com.keqi.apihu.manage.domain.vo.DictItemVO;
import com.keqi.apihu.manage.mapper.DictItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 程序启动后读取 sys_dict_item 表中的所数据，存储在内存中
 */
@Component
public class DictUtil implements CommandLineRunner {

    private static Map<String, List<DictItemVO>> dictMap;

    @Autowired
    private DictItemMapper dictItemMapper;

    @Override
    public void run(String... args) {
        dictMap = new HashMap<>();

        List<String> typeCodes = this.dictItemMapper.listTypeCode();
        for (String typeCode : typeCodes) {
            List<DictItemVO> dictItemVOS = this.dictItemMapper.findAllByTypeCode(typeCode);
            dictMap.put(typeCode, dictItemVOS);
        }
    }

    /**
     * 根据 typeCode 获取对应的 DictItemVO 列表
     *
     * @param typeCode typeCode
     * @return r
     */
    public static List<DictItemVO> listDictItem(String typeCode) {
        return dictMap.get(typeCode);
    }

    /**
     * 根据 typeCode 和 itemCode 获取对应的 DictItemVO
     *
     * @param typeCode typeCode
     * @param itemCode itemCode
     * @return r
     */
    public static DictItemVO getDictItem(String typeCode, String itemCode) {
        List<DictItemVO> dictItemVOS = dictMap.get(typeCode);
        for (DictItemVO t : dictItemVOS) {
            if (Objects.equals(itemCode, t.getItemCode())) {
                return t;
            }
        }
        return null;
    }

    /**
     * 根据 typeCode 和 itemCode 获取对应的 ItemValue
     *
     * @param typeCode typeCode
     * @param itemCode itemCode
     * @return r
     */
    public static String getItemValue(String typeCode, String itemCode) {
        DictItemVO dictItemVO = getDictItem(typeCode, itemCode);
        return dictItemVO == null ? null : dictItemVO.getItemValue();
    }

}
