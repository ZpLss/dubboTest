package com.zptest.demo.middleware;

import com.zptest.demo.exception.MessageBasedException;
import com.zptest.demo.middleware.request.MiddlewareReq;
import com.zptest.demo.middleware.response.MiddlewareResp;
import com.zptest.demo.util.AESCipher;
import com.zptest.demo.util.HttpClientUtil;
import com.zptest.demo.util.JsonMapper;
import com.zptest.demo.util.ThreadLocalUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * O
 * Created by wangxin on 2017/5/5.
 */
public class MiddlewareService {
    private static Logger logger = LoggerFactory.getLogger(MiddlewareService.class);
    private static final JsonMapper jsonMapper = JsonMapper.buildNonNullMapper();
    private static final String AES_KEY = MiddlewareServiceConstans.AES_KEY;


    /**
     * 调用中间层接口
     *
     * @param middlewareReq 入参request
     * @param clazz         结果response的class
     * @param <T>           结果response
     * @param <P>           入参request
     * @return 结果
     */
    public static <T extends MiddlewareResp, P extends MiddlewareReq> T
    requestMiddlewareService(P middlewareReq, Class<T> clazz) {
        Map<String, String> map = ThreadLocalUtil.get();
        if (map != null && map.size() > 0) {
            middlewareReq.setRequestId(map.get("requestId"));
            middlewareReq.setEquipmentId(map.get("equipmentId"));
            if (StringUtils.isNotBlank(map.get("sessionId")) && StringUtils.isBlank(middlewareReq.getSessionId())) {
                middlewareReq.setSessionId(map.get("sessionId"));
            }

            if (StringUtils.isBlank(middlewareReq.getIpAddress())) {
                middlewareReq.setIpAddress(map.get("ipAddress"));
            }
        }
        middlewareReq.makeSignmsg();
        String reqJsonStr = jsonMapper.toJson(middlewareReq);
        String apiInfo = "[" + middlewareReq.getFunctionName() + "][" + middlewareReq.getUrlAddress()
                + "][" + UUID.randomUUID().toString().replaceAll("-", "") + "]";
        String content = AESCipher.encryptAES(AES_KEY, reqJsonStr);
        logger.info("接口" + apiInfo + "入参：" + reqJsonStr);
//        logger.info("接口" + apiInfo + "content：" + content);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("encryptType", "aes");
        param.put("channel", middlewareReq.getChannel());
        param.put("content", content);
        long before = System.currentTimeMillis();
        String result = HttpClientUtil.httpPost((MiddlewareServiceConstans.MIDDLEWARE_SERVER_ROOT_PATH
                + middlewareReq.getUrlAddress() + MiddlewareServiceConstans.ADDRESS_TAIL), param);
        long after = System.currentTimeMillis();
        logger.info("接口" + apiInfo + "用时[" + (after - before) + "ms]返回报文：" + result);
        T middlewareResp = jsonMapper.fromJson(result, clazz);

        //如果返回结果为空抛出异常
        if (null == middlewareResp) {
            logger.info("接口" + apiInfo + "报文解析失败");
            throw new MessageBasedException("99999999", middlewareReq.getFunctionName() + "接口报文解析失败");
        }

        logger.info("接口" + apiInfo + "结果：code[" + middlewareResp.getCode() + "],message[" + middlewareResp.getMessage() + "]");
        //如果接口调用失败抛出异常
        if (!middlewareResp.isSuccess()) {
            //如果是登录状态过期或者其他设备登录，抛出异常，然后在异常处理处跳转登录页
            if (MiddlewareServiceConstans.LOGIN_EXPIRE_CODE.equals(middlewareResp.getCode())
                    || MiddlewareServiceConstans.LOGIN_OTHERDEVICE_CODE.equals(middlewareResp.getCode()) || MiddlewareServiceConstans.UPGRADING_CODE.equals(middlewareResp.getCode())) {
                throw new MessageBasedException(middlewareResp.getCode(), middlewareResp.getMessage());
            }
        }
        return middlewareResp;
    }
}
