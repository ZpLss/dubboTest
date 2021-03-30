package com.dubbo.sdk.model;

import java.io.Serializable;

/**
 * Author:zhangp
 * Date:2021/1/9 15:12
 * Description:
 */
public class User  implements Serializable {

    private static final long serialVersionUID = -7041432664513377648L;

    private String id;
    private String name;
    private Integer age;
    private String phone;
    private String email;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
