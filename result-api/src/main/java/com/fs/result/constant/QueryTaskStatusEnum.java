package com.fs.result.constant;

public enum QueryTaskStatusEnum {
    WAIT(0, "等待查询"),

    START(1, "开始查询"),

    END(2, "结束查询"),

    FAIL(-1, "查询异常");
    private Integer code;
    private String status;

    QueryTaskStatusEnum(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public static QueryTaskStatusEnum value(String value) {
        switch (value) {
            case "0":
                return WAIT;
            case "1":
                return START;
            case "2":
                return END;
            default:
                return FAIL;
        }
    }
}