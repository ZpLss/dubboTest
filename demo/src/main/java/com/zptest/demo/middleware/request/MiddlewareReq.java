package com.zptest.demo.middleware.request;

import cn.com.yhfund.yhtradeweb.middleware.MiddlewareServiceConstans;
import cn.com.yhfund.yhtradeweb.utils.Md5Encrypt;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangxin on 2017/5/5.
 */
public abstract class MiddlewareReq {
    private String appId;
    private String channel;//交易渠道
    private String signmode;//签名方式
    private String signmsg;//签名信息
    private String format;//响应格式
    private String timestamp;//时间戳
    private String userType;//投资者类型
    private String customizeTrust;// 自定义委托方式

    private String sessionId;
    protected String urlAddress; //方法地址
    protected String functionName; //接口名称

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 浏览器类型
     */
    private String browserType;

    /**
     * mac地址
     */
    private String mac;

    /**
     * 申请id
     */
    private String requestId;

    /**
     * 设备id，网上交易取IP地址
     */
    private String equipmentId;

    public abstract void setFunctionName();

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSignmode() {
        return signmode;
    }

    public void setSignmode(String signmode) {
        this.signmode = signmode;
    }

    public String getSignmsg() {
        return signmsg;
    }

    public void setSignmsg(String signmsg) {
        this.signmsg = signmsg;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCustomizeTrust() {
        return customizeTrust;
    }

    public void setCustomizeTrust(String customizeTrust) {
        this.customizeTrust = customizeTrust;
    }

    public abstract void setUrlAddress();

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public MiddlewareReq() {
        setUrlAddress();
        setFunctionName();
        this.appId = MiddlewareServiceConstans.PARAM_AZ_APPID;
        this.channel = MiddlewareServiceConstans.PARAM_CHANNEL;
        this.signmode = MiddlewareServiceConstans.PARAM_SIGNMODE;
        this.format = MiddlewareServiceConstans.PARAM_FORMAT;
        this.customizeTrust = MiddlewareServiceConstans.PARAM_CUSTTRUST;
        this.userType = MiddlewareServiceConstans.PARAM_USERTYPE;
    }

    public void makeSignmsg() {
        setSignmsg(null);
        String sigmsg = null;

        try {
            StringBuffer sinMagBuf = new StringBuffer();
            sinMagBuf.append(MiddlewareServiceConstans.PARAM_SIGNMSG);
            BeanInfo beanInfo = Introspector.getBeanInfo(this.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo
                    .getPropertyDescriptors();

            List<String> sigArr = new ArrayList<String>();

            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                if (!descriptor.getName().equals("class")) {
                    sigArr.add(descriptor.getName());
                }
            }

            Collections.sort(sigArr);

            for (String param : sigArr) {
                String value = BeanUtils.getProperty(this, param);
                if (StringUtils.isNotEmpty(value) && !"signmsg".equals(value)) {//&&!"encryptType".equals(value)
                    sinMagBuf.append(param);
                    sinMagBuf.append(value);
                }
            }

            sinMagBuf.append(MiddlewareServiceConstans.PARAM_SIGNMSG);
            sigmsg = Md5Encrypt.md5(sinMagBuf.toString(), "UTF-8");
            setSignmsg(sigmsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
