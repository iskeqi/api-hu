package com.keqi.apihu.pj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.core.common.Auth;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.manage.domain.vo.PageProjectVO;
import com.keqi.apihu.pj.domain.db.DatasourceDO;
import com.keqi.apihu.pj.domain.db.DatasourceTableColumnDO;
import com.keqi.apihu.pj.domain.db.DatasourceTableDO;
import com.keqi.apihu.pj.domain.param.CreateDatasourceParam;
import com.keqi.apihu.pj.domain.param.QueryDatasourceParam;
import com.keqi.apihu.pj.domain.param.UpdateDatasourceParam;
import com.keqi.apihu.pj.domain.vo.PageDatasourceVO;
import com.keqi.apihu.pj.mapper.DatasourceMapper;
import com.keqi.apihu.pj.mapper.DatasourceTableColumnMapper;
import com.keqi.apihu.pj.mapper.DatasourceTableMapper;
import com.keqi.apihu.pj.service.DatasourceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DatasourceServiceImpl implements DatasourceService {

    private final DatasourceMapper datasourceMapper;
    private final DatasourceTableMapper datasourceTableMapper;
    private final DatasourceTableColumnMapper datasourceTableColumnMapper;

    /**
     * 根据id删除数据源 todo
     * @param id id
     * @return r
     */
    @Override
    @Transactional
    public void deleteByPrimaryKey(Long id) {
        // 查找 数据源 -> 所有表结构 id列表
        List<DatasourceTableDO> datasourceTableDOList = this.datasourceTableMapper.findAllByDatasourceId(id);
        List<Long> dataSourceTableIdList = datasourceTableDOList.stream()
                .map(DatasourceTableDO::getId).collect(Collectors.toList());

        // 删除数据源
        this.datasourceMapper.deleteByPrimaryKey(id);

        // 删除数据源 -> 所有表结构
        this.datasourceTableMapper.deleteByDatasourceId(id);

        // 删除数据源 -> 所有表结构 -> 所有列
        if (CollUtil.isNotEmpty(dataSourceTableIdList)) {
            this.datasourceTableColumnMapper.deleteByDatasourceTableIdIn(dataSourceTableIdList);
        }
    }

    /**
     * 修改数据源
     * @param updateDatasourceParam updateDatasourceParam
     * @return r
     */
    @Override
    public void updateByPrimaryKey(UpdateDatasourceParam updateDatasourceParam) {
        DatasourceDO temp = this.datasourceMapper.
                findOneByNameAndProjectid(updateDatasourceParam.getName(), Auth.getProjectId());
        if (temp != null && !Objects.equals(updateDatasourceParam.getId(), temp.getId())) {
            throw new BusinessException("同名数据源已存在");
        }
        DatasourceDO datasourceDO = new DatasourceDO();
        BeanUtil.copyProperties(updateDatasourceParam, datasourceDO);
        this.datasourceMapper.updateByPrimaryKey(datasourceDO);
    }

    /**
     * 增加数据源
     *
     * @param createProjectParam createProjectParam
     */
    @Override
    @Transactional
    public void createDataSource(CreateDatasourceParam createProjectParam) {
        int count = this.datasourceMapper.dataSourceExist(createProjectParam.getName(), Auth.getProjectId());
        if (count > 0) {
            throw new BusinessException("同名数据源已存在");
        }

        DatasourceDO datasourceDO = new DatasourceDO();
        datasourceDO.setProjectid(Auth.getProjectId());
        BeanUtil.copyProperties(createProjectParam, datasourceDO);
        this.datasourceMapper.insert(datasourceDO);
    }

    /**
     * 分页查询数据源列表
     *
     * @param queryDatasourceParam queryDatasourceParam
     * @return r
     */
    @Override
    public AjaxPageEntity<PageProjectVO> pageDataSource(QueryDatasourceParam queryDatasourceParam) {
        queryDatasourceParam.setProjectId(Auth.getProjectId());
        int total = this.datasourceMapper.countDataSource(queryDatasourceParam);

        AjaxPageEntity ajaxPageEntity = new AjaxPageEntity();

        if (total > 0) {
            List<PageDatasourceVO> pageDatasourceVOList = this.datasourceMapper.pageDataSource(queryDatasourceParam);
            ajaxPageEntity.setTotal(total);
            ajaxPageEntity.setList(pageDatasourceVOList);
        }

        return ajaxPageEntity;
    }

    /**
     * 在线读取数据库
     *
     * @param id id
     */
    @Override
    @Transactional
    public void readDataSource(Long id) {
        DatasourceDO datasourceDO = this.datasourceMapper.selectByPrimaryKey(id);
        // 读取数据源中的表结构和字段信息
        List<DatasourceTableDO> datasourceTableDOList = this.readAllTablesAndColumns(datasourceDO);

        // 批量保存所有表结构
        for (DatasourceTableDO datasourceTableDO : datasourceTableDOList) {
            datasourceTableDO.setDatasourceId(id);
        }
        if (datasourceTableDOList.size() > 0) {
            this.datasourceTableMapper.batchInsert(datasourceTableDOList);
        }

        // 批量保存所有表中的所有列
        List<DatasourceTableColumnDO> datasourceTableColumnDOList = new ArrayList<>();
        for (DatasourceTableDO pjDatasourceTableDO : datasourceTableDOList) {
            for (DatasourceTableColumnDO pjDatasourceTableColumnDO : pjDatasourceTableDO.getDatasourceTableColumnDOList()) {
                pjDatasourceTableColumnDO.setDatasourceTableId(pjDatasourceTableDO.getId());
                datasourceTableColumnDOList.add(pjDatasourceTableColumnDO);
            }
        }
        if (datasourceTableColumnDOList.size() > 0) {
            this.datasourceTableColumnMapper.batchInsert(datasourceTableColumnDOList);
        }

    }


    //================================私有方法================================//

    /**
     * 读取指定数据源的所有表结构和表对应的列信息
     * @param datasourceDO datasourceDO
     * @return r
     */
    private List<DatasourceTableDO> readAllTablesAndColumns(DatasourceDO datasourceDO) {
        List<DatasourceTableDO> datasourceTableDOList = new ArrayList<>();
        Connection connection = null;
        try {
            // 加载驱动&创建连接
            Class.forName(datasourceDO.getDriverClassName());
            connection = DriverManager.
                    getConnection(datasourceDO.getUrl(), datasourceDO.getUsername(), datasourceDO.getPassword());
            if (Objects.isNull(connection)) {
                throw new BusinessException("创建连接失败");
            }

            // 获取元数据信息
            DatabaseMetaData metaData = connection.getMetaData();

            // 从 url 中截取到 DB 名称（示例：jdbc:mysql://10.10.20.200:3306/api-hu?useUnicode=true）
            int end = datasourceDO.getUrl().indexOf('?');
            int start = datasourceDO.getUrl().lastIndexOf('/');
            String dbName = datasourceDO.getUrl().substring(start + 1, end);

            // catalog 参数指的是 DB 名称，如果不指定，则会把 DBMS 中的所有 DB 的所有表都读取出来
            ResultSet tables = metaData.getTables(dbName, null, null, new String[]{"TABLE"});
            // 遍历所有表
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                String tableComment = tables.getString("REMARKS");
                DatasourceTableDO datasourceTableDO = DatasourceTableDO.builder().
                        tableName(tableName).
                        tableComment(tableComment)
                        .build();

                datasourceTableDO.setDatasourceTableColumnDOList(new ArrayList<>());

                ResultSet columns = metaData.getColumns(null, null, tableName, null);
                // 遍历表中的所有字段
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME"); // 列名称
                    String columnComment = columns.getString("REMARKS"); // 列描述
                    String columnType = columns.getString("TYPE_NAME").toLowerCase(); // 列类型
                    DatasourceTableColumnDO pjDatasourceTableColumnDO = DatasourceTableColumnDO.builder()
                            .columnName(columnName)
                            .columnComment(columnComment)
                            .columnType(columnType)
                            .build();
                    datasourceTableDO.getDatasourceTableColumnDOList().add(pjDatasourceTableColumnDO);
                }
                datasourceTableDOList.add(datasourceTableDO);
            }
        } catch (ClassNotFoundException e) {
            throw new BusinessException("对应驱动不存在");
        } catch (SQLException e) {
            throw new BusinessException("创建连接失败");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return datasourceTableDOList;
    }

}
