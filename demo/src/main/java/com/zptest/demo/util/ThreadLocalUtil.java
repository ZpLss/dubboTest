package com.zptest.demo.util;

import java.util.Map;

/**
 * @author: wanggy
 * @Date: 2017/12/5
 * @Time: 9:22
 * Description: threadlocal工具类，主要用于公共参数传递
 */
public class ThreadLocalUtil {
    private static final ThreadLocal threadSession = new ThreadLocal();

    public static Map<String, String> get() {
        Map<String, String> map = (Map<String, String>) threadSession.get();
        return map;
    }

    public static Map<String, String> set(Map<String, String> map) {
        threadSession.set(map);
        return map;
    }
}
