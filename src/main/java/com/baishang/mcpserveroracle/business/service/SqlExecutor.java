package com.baishang.mcpserveroracle.business.service;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SqlExecutor {
    @Resource
    private JdbcTemplate jdbc;
    private static final int QUERY_LIMIT_SIZE = 1000; // 查询大小限制

    /**
     * 执行SQL查询并返回FastJson格式结果
     *
     * @param sqlString SQL查询语句
     * @return JSON字符串 (成功返回数据数组，失败返回错误对象)
     */
    public String executeSql(String sqlString) {
        try {
            SqlRowSet rowSet = jdbc.queryForRowSet(sqlString);
            return convertToJson(rowSet).toJSONString();
        } catch (Exception e) {
            log.error("SQL执行失败", e);
            return buildErrorJson(e).toJSONString();
        }
    }

    private JSONArray convertToJson(SqlRowSet rowSet) {
        JSONArray result = new JSONArray();
        String[] columns = rowSet.getMetaData().getColumnNames();
        int rowCount = 0;

        while (rowSet.next() && rowCount++ < QUERY_LIMIT_SIZE) {
            JSONObject row = new JSONObject();
            for (String col : columns) {
                row.put(col, rowSet.getObject(col));
            }
            result.add(row);
        }
        return result;
    }

    private JSONObject buildErrorJson(Exception e) {
        return new JSONObject()
                .fluentPut("error", e.getMessage())
                .fluentPut("status", "failed");
    }
}
