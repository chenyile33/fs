package com.fs.result.service;

import com.fs.result.common.QueryCondition;

import java.util.List;

/**
 * @author chenyile
 * @date 2022/5/23  18:56
 * @description:
 */
public interface MongoService<T> {

    //根据queryCondition查询mongodb
    List<T> findAllDataByQueryCondition(QueryCondition queryCondition);

    List<T> findDataByRequestIdAndTableName(String requestId, String tableName);

    //数据插入mongodb
    void insertData(T data, String requestId);

}
