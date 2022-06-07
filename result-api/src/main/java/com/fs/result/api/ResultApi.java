package com.fs.result.api;

import com.fs.result.common.QueryCondition;
import com.fs.result.common.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author chenyile
 * @date 2022/5/24  14:15
 * @description:
 */
public interface ResultApi {
    String PREFIX = "result";


    /**
     * 根据requestId查询mongo
     */
    @PostMapping("findDataByRequestId")
    Response findDataByRequestId(@RequestBody QueryCondition queryCondition);

    /**
     * 根据requestId + tableName查询mongo
     */
    @PostMapping("findDataByRequestIdAndTableName")
    Response findDataByRequestIdAndTableName(@RequestBody QueryCondition queryCondition);

    @PostMapping("findTaskStatus")
    Response findTaskStatus(@RequestBody QueryCondition queryCondition);
}
