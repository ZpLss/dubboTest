package com.zptest.demo.exception;

/**
 * 用于处理ajax异常，统一返回ajax异常后的json格式
 * Created by wanggy on 2017/9/7.
 */
public class JsonMessageException extends MessageBasedException {
    public JsonMessageException(String code, String message) {
        super(code, message);
    }
}
