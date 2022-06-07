package com.fs.result.constant;


public enum ExecStatusEnum {

    WAIT(0, "等待查询"),

    START(1, "开始查询"),

    END(2, "结束查询"),

    FAIL(-1, "查询异常");

    private Integer code;
    private String status;

    ExecStatusEnum(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public static ExecStatusEnum value(String value) {
        switch (value) {
            case "1":
                return WAIT;
            case "2":
                return START;
            case "3":
                return END;
            default:
                return FAIL;
        }
    }
}
