package com.baishang.mcpserveroracle.business.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColumnDetailVo {
    private String tableName; // 表名
    private String columnName; // 列名
    private String dataType; // 数据类型
    private String dataLength; // 长度
    private String dataPrecision; // 精度（数字类型）
    private String dataScale; // 小数位（数字类型）
    private String nullable; // 是否允许NULL
    private String comments; // 列注释
}
