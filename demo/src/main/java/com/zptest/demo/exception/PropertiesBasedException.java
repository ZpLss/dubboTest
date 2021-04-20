package com.zptest.demo.exception;


import com.zptest.demo.common.MessageConfig;

/**
 * 基于配置文件的基础异常类
 * Created by wanggy on 2017/8/2.
 */
public class PropertiesBasedException extends MessageBasedException {

    private String code;
    private String[] params;

    public PropertiesBasedException(String code) {
        super(code, null);
        this.code = code;
    }

    public PropertiesBasedException(String code, String... params) {
        super(code, null);
        this.code = code;
        this.params = params;
    }
    @Override
    public String getCode() {
        return code;
    }
    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    @Override
    public String getMessage() {
        return MessageConfig.getErrorMsg(code, params);
    }
}
