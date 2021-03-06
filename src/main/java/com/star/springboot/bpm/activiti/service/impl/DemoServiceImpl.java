package com.star.springboot.bpm.activiti.service.impl;

import com.star.springboot.bpm.activiti.bean.Demo;
import com.star.springboot.bpm.activiti.persistence.dao.IDemoDao;
import com.star.springboot.bpm.activiti.service.IDemoService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl extends BaseServiceImpl<Demo, Long> implements IDemoService, InitializingBean {

    @Autowired
    private IDemoDao demoDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        super.setDao(demoDao);
    }

}
