package com.baishang.mcpserveroracle.business.mapper;

import com.baishang.mcpserveroracle.business.domain.ColumnDetailVo;
import com.baishang.mcpserveroracle.business.domain.TableDetailVo;

import java.util.List;

public interface UserTableMapper {
    /**
     * 查询Oracle数据库中表的名称和描述
     *
     * @return Oracle数据库中表的名称和描述集合
     */
    List<TableDetailVo> getTableDetail();

    List<ColumnDetailVo> getColumnDetail(String tableName);

    List<String> getOracleVersionInfo();
}
