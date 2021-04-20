package com.zptest.demo.controller;

import cn.com.yhfund.yhtradeweb.common.MessageConfig;
import cn.com.yhfund.yhtradeweb.exception.JsonMessageException;
import cn.com.yhfund.yhtradeweb.exception.JsonPropertiesException;
import cn.com.yhfund.yhtradeweb.exception.MessageBasedException;
import cn.com.yhfund.yhtradeweb.exception.PropertiesBasedException;
import cn.com.yhfund.yhtradeweb.middleware.MiddlewareServiceConstans;
import cn.com.yhfund.yhtradeweb.middleware.response.MiddlewareResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

/**
 * 全局异常统一处理
 * Created by wanggy on 2017/9/6.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 日志记录
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * bean validator 绑定异常处理
     *
     * @param model
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public String bindingValidExceptionHandle(Model model, BindException e) {
        LOGGER.error("全局异常处理，bean validator绑定异常", e);
        List<FieldError> errorList = e.getFieldErrors();
        FieldError fieldError = errorList.get(errorList.size() - 1);
        String errorMsg = MessageConfig.getErrorMsg(fieldError.getDefaultMessage());
        LOGGER.error("全局异常处理，bean validator绑定异常信息：key[{}],value[{}]",
                fieldError.getDefaultMessage(), errorMsg);
        model.addAttribute("errorMsg", errorMsg);
        return "/error/error";
    }

    /**
     * 处理ajax异常，统一返回错误
     *
     * @param model
     * @param e
     * @return
     */
    @ExceptionHandler(value = {JsonPropertiesException.class, JsonMessageException.class})
    @ResponseBody
    public MiddlewareResp jsonExceptionHandle(Model model, MessageBasedException e) {
        LOGGER.error("全局异常处理，JsonPropertiesException、JsonMessageException异常", e);
        MiddlewareResp middlewareResp = new MiddlewareResp();
        middlewareResp.setCode(e.getCode());
        middlewareResp.setMessage(e.getMessage());
//        model.addAttribute("errorMsg", e.getMessage());
        return middlewareResp;
    }

    /**
     * 配置错误信息异常处理
     *
     * @param model
     * @param e
     * @return
     */
    @ExceptionHandler(PropertiesBasedException.class)
    public String propertiesExceptionHandle(Model model, PropertiesBasedException e) {
        LOGGER.error("全局异常处理，配置文件错误信息异常", e);
        model.addAttribute("errorMsg", e.getMessage());

        //如果是权限、审核状态异常，则到无权限错误页面
        if ("02999903".equals(e.getCode()) || "02999901".equals(e.getCode())
                || "02999905".equals(e.getCode()) || "02999906".equals(e.getCode())
                || "02010101".equals(e.getCode()) || "02010102".equals(e.getCode())) {
            model.addAttribute("code", e.getCode());
            return "/error/noPermissionError";
        }

        return "/error/error";
    }

    /**
     * 错误信息异常处理
     *
     * @param model
     * @param e
     * @return
     */
    @ExceptionHandler(MessageBasedException.class)
    public String messageExceptionHandle(Model model, RedirectAttributes redirectAttributes,
                                         HttpSession session, MessageBasedException e) {
        LOGGER.error("全局异常处理，错误信息异常", e);

        //如果是中间层登录状态过期、或者是其他设备登录，跳转登录页
        if (MiddlewareServiceConstans.LOGIN_EXPIRE_CODE.equals(e.getCode())
                || MiddlewareServiceConstans.LOGIN_OTHERDEVICE_CODE.equals(e.getCode())) {
            //清除session登录信息
            Enumeration em = session.getAttributeNames();
            while (em.hasMoreElements()) {
                session.removeAttribute(em.nextElement().toString());
            }
            redirectAttributes.addFlashAttribute("errorMsg", e.getMessage());
            return "redirect:/account/goLogin.do";
        }

        model.addAttribute("errorMsg", e.getMessage());
        return "/error/error";
    }

    /**
     * 其他异常处理
     *
     * @param model
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String otherExceptionHandle(Model model, Exception e) {
        LOGGER.error("全局异常处理，其他异常", e);
        model.addAttribute("errorMsg", MessageConfig.getErrorMsg("02999902"));
        return "/error/error";
    }

}
