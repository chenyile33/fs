package com.fs.result.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenyile
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueryTaskStatusVo {
    //原始任务状态
    private String value;
    //转义后的任务状态
    private String valueDic;
}
