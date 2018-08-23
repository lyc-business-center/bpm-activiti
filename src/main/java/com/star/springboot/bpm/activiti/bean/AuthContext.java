package com.star.springboot.bpm.activiti.bean;

import lombok.Data;

@Data
public class AuthContext extends BaseBean {

    private Long userId;
    private String tokenKey;
}
