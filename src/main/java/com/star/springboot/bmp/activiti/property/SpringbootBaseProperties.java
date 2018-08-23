package com.star.springboot.bmp.activiti.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by MaJingcao on 2018/3/14.
 * Copyright by syswin
 */
@Component
@PropertySource("classpath:springbootBase.properties")
public class SpringbootBaseProperties {

    @Value("${test.name}")
    private String name;

    public String getName(){
        return name;
    }

}
