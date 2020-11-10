package com.keqi.apihu.pj;

import com.keqi.apihu.core.common.Auth;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.pj.domain.db.DatasourceDO;
import com.keqi.apihu.pj.domain.param.CreateDatasourceParam;
import com.keqi.apihu.pj.mapper.DatasourceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class DatasourceServiceImpl implements DatasourceService{

    private final DatasourceMapper datasourceMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return datasourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DatasourceDO record) {
        return datasourceMapper.insert(record);
    }

    @Override
    public int insertSelective(DatasourceDO record) {
        return datasourceMapper.insertSelective(record);
    }

    @Override
    public DatasourceDO selectByPrimaryKey(Long id) {
        return datasourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DatasourceDO record) {
        return datasourceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DatasourceDO record) {
        return datasourceMapper.updateByPrimaryKey(record);
    }

    /**
     * 增加数据源
     *
     * @param createProjectParam createProjectParam
     */
    @Override
    @Transactional
    public void createDataSource(CreateDatasourceParam createProjectParam) {
        Long projectId = Auth.getProjectId();
        int count = this.datasourceMapper.dataSourceExist(createProjectParam.getName(), projectId);
        if (count > 0) {
            throw new BusinessException("同名数据源已存在");
        }
        // this.datasourceMapper.insert()
    }

}
