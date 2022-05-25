package com.fs.result.client;

import com.fs.result.api.ResultApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author chenyile
 * @date 2022/5/24  14:15
 * @description:
 */

@FeignClient(name = "result-service",contextId = "ResultClient",path = ResultApi.PREFIX)
public interface ResultClient extends ResultApi {
}
