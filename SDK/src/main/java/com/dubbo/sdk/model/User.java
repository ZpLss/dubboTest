package com.dubbo.sdk.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Author:zhangp
 * Date:2021/1/9 15:12
 * Description:
 */
@Data
public class User  implements Serializable {

    private static final long serialVersionUID = -7041432664513377648L;

    private String id;
    private String name;
    private Integer age;
    private String phone;
    private String email;
}
