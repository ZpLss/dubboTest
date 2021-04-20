package com.zptest.demo.exception;

/**
 * 基于错误信息的基础异常类
 * Created by wanggy on 2017/8/2.
 */
public class MessageBasedException extends RuntimeException {
    private String code;

    private String message;

    public MessageBasedException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
