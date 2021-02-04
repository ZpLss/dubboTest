package com.dubbo.sdk.model;

import java.io.Serializable;

/**
 * Author:zhangp
 * Date:2021/2/4 22:29
 * Description:
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -8061533119337780497L;

    private boolean success;
    private String msg;
    private Integer code;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
