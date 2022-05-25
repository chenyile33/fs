package com.fs.result.common;

import java.io.Serializable;

/**
 * 统一响应给前端的信息
 */
public class Response<T> implements Serializable {
    //状态码
    private int code;
    //返回消息
    private String msg;
    //具体数据
    private T data;
    //分页信息
    private PageEntity pageEntity;

    public Response() {
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(int code, String msg, T data, PageEntity pageEntity) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.pageEntity = pageEntity;
    }

    public static <T> Response ok(T data) {
        return new Response<>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), data);
    }

    public static <T> Response ok(T data, PageEntity pageEntity) {
        return new Response<>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), data, pageEntity);
    }

    public static Response<String> error(ResponseEnum responseEnum) {
        return new Response<>(responseEnum.getCode(), responseEnum.getMsg());
    }

    //传自定义的状态码和msg
    public static Response<String> error(int code, String msg) {
        return new Response<>(code, msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PageEntity getPageEntity() {
        return pageEntity;
    }

    public void setPageEntity(PageEntity pageEntity) {
        this.pageEntity = pageEntity;
    }
}
