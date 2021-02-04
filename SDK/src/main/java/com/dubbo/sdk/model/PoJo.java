package com.dubbo.sdk.model;

import java.io.Serializable;

/**
 * Author:zhangp
 * Date:2021/2/4 22:45
 * Description:
 */
public class PoJo implements Serializable {

    private static final long serialVersionUID = -1393030452428760194L;
    private String id;
    private String name;

    public PoJo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
