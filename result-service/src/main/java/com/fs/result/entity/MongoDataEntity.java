package com.fs.result.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenyile
 * @date 2022/5/23  20:33
 * @description: 数据统一入库的实体
 */

@Document("uqbing")
@Data
public class MongoDataEntity<T> implements Serializable {
    //唯一请求ID
    private String requestId;
    //表名，可以调用元数据服务获取到表字段信息
    private String tableName;
    //数据入库时间，与集合的ttl索引同名，数据有效期与索引设置的值有关，这里索引设了1天
    private Date insertMongoDbTime;
    //es,hbase等查询到的数据
    private T data;

}
