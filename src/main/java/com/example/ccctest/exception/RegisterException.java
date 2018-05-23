package com.example.ccctest.exception;

import com.example.ccctest.enums.RegisterEnum;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 21:04 2018/4/22/022
 */
public class RegisterException extends RuntimeException{
    private Integer code;

    public RegisterException(RegisterEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public RegisterException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
