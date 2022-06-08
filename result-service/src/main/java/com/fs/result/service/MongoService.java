package com.fs.result.service;

import com.fs.result.common.QueryCondition;

import java.util.List;
import java.util.Map;

/**
 * @author chenyile
 * @date 2022/5/23  18:56
 * @description:
 */
public interface MongoService<T> {

    //根据queryCondition查询mongodb
    List<T> findAllDataByQueryCondition(QueryCondition queryCondition);

    List<T> findDataByRequestIdAndTableName(String requestId, String tableName);

    //转义任务查询状态
    Map<String, Object> getTaskStatus(QueryCondition queryCondition);

}
