package com.star.springboot.bmp.activiti.bean;

import lombok.Data;

@Data
public class AuthContext extends BaseBean {

    private Long userId;
    private String tokenKey;
}
