package com.fs.result.common;


public enum ResponseEnum {

    FAILED(1000, "失败"),
    SUCCESS(2000, "成功");
    //状态码
    private int code;
    //返回消息
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
