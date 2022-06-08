package com.fs.result.service.impl;

import com.fs.result.common.QueryCondition;
import com.fs.result.constant.QueryTaskStatusEnum;
import com.fs.result.dao.CommonRepository;
import com.fs.result.entity.MongoDataEntity;
import com.fs.result.service.MongoService;
import com.fs.result.vo.QueryTaskStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author chenyile
 * @date 2022/5/23  18:58
 * @description:
 */
@Service
public class MongoServiceImpl implements MongoService {
    @Autowired
    CommonRepository commonRepository;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //整体的查询状态
    private final String SUMMARY_STATUS = "summaryStatus";


    @Override
    public List<MongoDataEntity<Object>> findAllDataByQueryCondition(QueryCondition queryCondition) {

        return commonRepository.findByRequestId(queryCondition.getRequestId());
    }

    @Override
    public List<MongoDataEntity<Object>> findDataByRequestIdAndTableName(String requestId, String tableName) {
        return commonRepository.findByRequestIdAndTableName(requestId, tableName);
    }

    @Override
    public Map<String, QueryTaskStatusVo> getTaskStatus(QueryCondition queryCondition) {
        Map<String, QueryTaskStatusVo> result = new HashMap<>();
        //从redis中读取任务状态
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(queryCondition.getRequestId());
        //获取整体的查询状态信息
        entries.put(SUMMARY_STATUS, getSummaryStatusCode(entries));
        //状态转义
        entries.forEach((k, v) -> {
            QueryTaskStatusVo queryTaskStatusVo = new QueryTaskStatusVo(String.valueOf(entries.get(k)),
                    QueryTaskStatusEnum.value(String.valueOf(entries.get(k))).getStatus());
            result.put(String.valueOf(k), queryTaskStatusVo);
        });
        return result;
    }


    private int getSummaryStatusCode(Map<Object, Object> entries) {
        Collection<Object> values = entries.values();
        Set<Integer> set = new HashSet<>();
        for (Object value : values) {
            set.add(Integer.valueOf(String.valueOf(value)));
        }
        //状态只有等待查询则返回等待查询
        Set<Integer> startSet = new HashSet<>();
        startSet.add(QueryTaskStatusEnum.WAIT.getCode());
        if (startSet.containsAll(set)) {
            return QueryTaskStatusEnum.WAIT.getCode();
        }
        //状态只有查询异常和完成，则返回查询接收
        Set<Integer> endSet = new HashSet<>();
        endSet.add(QueryTaskStatusEnum.FAIL.getCode());
        endSet.add(QueryTaskStatusEnum.END.getCode());
        if (endSet.containsAll(set)) {
            return QueryTaskStatusEnum.END.getCode();
        }
        //其他情况，返回开始查询状态
        return QueryTaskStatusEnum.START.getCode();

    }

}
