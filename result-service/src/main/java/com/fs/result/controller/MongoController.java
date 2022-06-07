package com.fs.result.controller;

import com.fs.result.api.ResultApi;
import com.fs.result.common.QueryCondition;
import com.fs.result.common.Response;
import com.fs.result.constant.ExecStatusEnum;
import com.fs.result.entity.MongoDataEntity;
import com.fs.result.service.MongoService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenyile
 * @date 2022/5/23  17:48
 * @description: 查询mongo数据库的相关接口
 */
@RestController
@RequestMapping(ResultApi.PREFIX)
public class MongoController implements ResultApi {

    @Autowired
    MongoService mongoService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //根据requestId查询mongo
    @Override
    public Response findDataByRequestId(@RequestBody QueryCondition queryCondition) {
        List<MongoDataEntity<Object>> data = mongoService.findAllDataByQueryCondition(queryCondition);
        Map<String, List<MongoDataEntity<Object>>> collect = data.stream().collect(Collectors.groupingBy((MongoDataEntity::getTableName)));
        return Response.ok(collect);
    }

    @Override
    public Response findDataByRequestIdAndTableName(QueryCondition queryCondition) {
        List<MongoDataEntity<Object>> collect = mongoService.findDataByRequestIdAndTableName(queryCondition.getRequestId(), queryCondition.getTableName());
        return Response.ok(collect);
    }

    @Override
    public Response findTaskStatus(QueryCondition queryCondition) {
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(queryCondition.getRequestId());
        for (Object o : entries.keySet()) {
            entries.put(o, ExecStatusEnum.value(entries.get(o).toString()).getStatus());
        }
        return Response.ok(entries);
    }


    //数据插入mongodb的方法


    //该方法是在数据处理服务模块上开发的
    @GetMapping("insertData")
    public Response insertData() {
        String data = "{\"email\":\"lisi@qq.com\",\"name\":\"李四\",\"age\":\"10\"}";
        mongoService.insertData(data, "112");
        return Response.ok("ok");
    }

}
