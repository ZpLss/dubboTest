package com.zptest.demo.exception;

/**
 * 用于处理ajax异常，统一返回ajax异常后的json格式
 * Created by wanggy on 2017/9/7.
 */
public class JsonPropertiesException extends PropertiesBasedException {
    public JsonPropertiesException(String code) {
        super(code);
    }

    public JsonPropertiesException(String code, String... params) {
        super(code, params);
    }
}
