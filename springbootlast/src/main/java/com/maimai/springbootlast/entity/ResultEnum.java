package com.maimai.springbootlast.entity;

public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "我猜你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),

    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static String getMsgByCode(Integer code) {
        for (ResultEnum o : ResultEnum.values()) {
            if (o.getCode().equals(code)) {
                return o.getMsg();
            }
        }
        return null;
    }

    public static Integer getCodeByMsg(String msg) {
        for (ResultEnum value : ResultEnum.values()) {
            if (value.getMsg().equals(msg)) {
                return value.getCode();
            }
        }
        return null;
    }

    public static ResultEnum getResultEnumByCode(Integer code) {
        for (ResultEnum o : ResultEnum.values()) {
            if (o.getCode().equals(code)) {
                return o;
            }
        }
        return null;
    }

    public static ResultEnum getResultEnumByMsg(String msg) {
        for (ResultEnum value : ResultEnum.values()) {
            if (value.getMsg().equals(msg)) {
                return value;
            }
        }
        return null;
    }


}
