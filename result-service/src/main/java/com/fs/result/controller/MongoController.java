package com.fs.result.controller;

import com.fs.result.api.ResultApi;
import com.fs.result.common.QueryCondition;
import com.fs.result.common.Response;
import com.fs.result.entity.MongoDataEntity;
import com.fs.result.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //根据requestId查询mongo
    @Override
    public Response findDataByRequestId(@RequestBody QueryCondition queryCondition) {
        List<MongoDataEntity<Object>> allDataByQueryCondition = mongoService.findAllDataByQueryCondition(queryCondition);
        return Response.ok(allDataByQueryCondition);
    }

    //TODO 统计接口

    //TODO 进度查询接口

    //数据插入mongodb的方法
    //该方法是在数据处理服务模块上开发的
    @GetMapping("insertData")
    public Response insertData() {
        String data = "{\"tableName\":\"nb_app_auth\",\"name\":\"张三\",\"age\":\"10\"}";
        mongoService.insertData(data, "112");
        return Response.ok("ok");
    }
}
