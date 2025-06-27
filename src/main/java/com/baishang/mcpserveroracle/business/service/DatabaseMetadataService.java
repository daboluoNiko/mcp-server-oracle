package com.baishang.mcpserveroracle.business.service;

import com.baishang.mcpserveroracle.business.domain.ColumnDetailVo;
import com.baishang.mcpserveroracle.business.domain.TableDetailVo;
import com.baishang.mcpserveroracle.business.mapper.UserTableMapper;
import jakarta.annotation.Resource;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseMetadataService {
    @Autowired
    private UserTableMapper userTableMapper;

    @Resource
    private SqlExecutor sqlExecutor;

    /**
     * 获取Oracle数据库中表的名称和描述
     */
    @Tool(name = "getTableDetails", description = "获取Oracle数据库中表的名称和描述。返回包含数据库所有业务表信息。")
    public List<TableDetailVo> getTableDetails() {
        return userTableMapper.getTableDetail();
    }

    /**
     * 获取Oracle数据库中的表名、列名和列的描述。
     */
    @Tool(name = "getColumnDetails", description = "获取Oracle数据库中的表名、列名和列的描述。")
    public List<ColumnDetailVo> getColumnDetails(String tableName) {
        return userTableMapper.getColumnDetail(tableName);
    }

    /**
     * 执行sql查询
     */
    @Tool(name = "executeSql", description = "对Oracle数据库执行SQL查询。")
    public String executeSql(String sql) {
        return sqlExecutor.executeSql(sql);
    }

    /**
     * 获取数据版本信息
     */
    @Tool(name = "getOracleVersionInfo", description = "获取oracle数据库版本信息。避免不同版本之间的sql差异从而导致错误。")
    public List<String> getOracleVersionInfo() {
        return userTableMapper.getOracleVersionInfo();
    }

}
