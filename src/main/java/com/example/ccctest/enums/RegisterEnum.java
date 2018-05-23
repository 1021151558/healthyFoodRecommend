package com.example.ccctest.enums;


import lombok.Getter;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 20:55 2018/4/22/022
 */
@Getter
public enum RegisterEnum {

    SUCCESS(0,"注册成功"),
    FAIL(1,"注册失败"),

    ;
    private Integer code;

    private String message;

    RegisterEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
