package com.fs.result.service.impl;

import com.fs.result.dao.CommonRepository;
import com.fs.result.common.QueryCondition;
import com.fs.result.entity.MongoDataEntity;
import com.fs.result.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chenyile
 * @date 2022/5/23  18:58
 * @description:
 */
@Service
public class MongoServiceImpl implements MongoService {
    @Autowired
    CommonRepository commonRepository;

    @Override
    public List<MongoDataEntity<Object>> findAllDataByQueryCondition(QueryCondition queryCondition) {
        return commonRepository.findByRequestId(queryCondition.getRequestId());
    }

    @Override
    public void insertData(Object data, String requestId) {
        MongoDataEntity<Object> mongoDataEntity = new MongoDataEntity<>();
        mongoDataEntity.setData(data);
        mongoDataEntity.setInsertMongoDbTime(new Date());
        mongoDataEntity.setRequestId(requestId);
        mongoDataEntity.setTableName("nb_app_auth");
        commonRepository.insert(mongoDataEntity);
    }


}
