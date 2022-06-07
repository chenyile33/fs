package com.fs.result.common;

import lombok.Data;

/**
 * @author chenyile
 * @date 2022/5/23  18:32
 * @description: 统一查询mongodb的条件
 */
@Data
public class QueryCondition {
    //请求ID
    private String requestId;
    //表名
    private String tableName;
}
