package com.fs.result.dao;

import com.fs.result.entity.MongoDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author chenyile
 * @date 2022/5/23  22:27
 * @description:
 */
public interface CommonRepository extends MongoRepository<MongoDataEntity, String> {

    List<MongoDataEntity<Object>> findByRequestId(String requestId);

    List<MongoDataEntity<Object>> findByRequestIdAndTableName(String requestId, String tableName);
}
