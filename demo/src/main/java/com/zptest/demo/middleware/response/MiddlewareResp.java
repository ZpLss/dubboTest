package com.zptest.demo.middleware.response;


import com.zptest.demo.middleware.MiddlewareServiceConstans;

/**
 * Created by wangxin on 2017/5/5.
 */
public class MiddlewareResp {
//    @JsonIgnore
    private String code;
//    @JsonIgnore
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //    @JsonIgnore
    public boolean isSuccess() {
        return MiddlewareServiceConstans.SUCCESS_CODE.equals(code) ? true : false;
    }

    @Override
    public String toString() {
        return "STBaseResp{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
