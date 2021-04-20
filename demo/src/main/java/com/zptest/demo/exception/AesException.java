package com.zptest.demo.exception;


/**
 * 推送异常
 *
 * @author zhengdongwen
 * @create 2017-02-16 上午11:18
 */
public class AesException extends ApplicationException {

    private int code;

    private String exp_message;

    public AesException() {
        super();
    }
    public AesException(int code, String message) {
        super(code,message);
        this.code = code;
        this.exp_message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getExp_message() {
        return exp_message;
    }

    public void setExp_message(String exp_message) {
        this.exp_message = exp_message;
    }
}
