package com.keqi.apihu.pj.service;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.apihu.pj.domain.PjConstant;
import com.keqi.apihu.pj.domain.db.ApiGroupDO;
import com.keqi.apihu.pj.domain.param.CreateApiGroupParam;
import com.keqi.apihu.pj.mapper.ApiGroupMapper;
import com.keqi.apihu.pj.service.impl.ApiGroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ApiGroupServiceImpl implements ApiGroupService{

    private final ApiGroupMapper apiGroupMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return apiGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ApiGroupDO record) {
        return apiGroupMapper.insert(record);
    }

    @Override
    public int insertSelective(ApiGroupDO record) {
        return apiGroupMapper.insertSelective(record);
    }

    @Override
    public ApiGroupDO selectByPrimaryKey(Long id) {
        return apiGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ApiGroupDO record) {
        return apiGroupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ApiGroupDO record) {
        return apiGroupMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<ApiGroupDO> list) {
        return apiGroupMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<ApiGroupDO> list) {
        return apiGroupMapper.batchInsert(list);
    }

    /**
     * 增加API分组
     *
     * @param createApiGroupParam createApiGroupParam
     */
    @Override
    @Transactional
    public void createApiGroup(CreateApiGroupParam createApiGroupParam) {
        // 如果 parentId 为 null，则为顶级分组，parentId 为 0
        if (Objects.isNull(createApiGroupParam.getParentId())) {
            createApiGroupParam.setParentId(PjConstant.rootParentId);
        }
        // todo 明天再来写吧，晚上回去先吃饭洗澡，再学习两小时，今天必须做到
        ApiGroupDO apiGroupDO = new ApiGroupDO();
        BeanUtil.copyProperties(createApiGroupParam, apiGroupDO);



    }

}
