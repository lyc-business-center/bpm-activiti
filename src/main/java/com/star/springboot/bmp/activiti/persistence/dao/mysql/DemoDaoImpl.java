package com.star.springboot.bmp.activiti.persistence.dao.mysql;

import com.star.springboot.bmp.activiti.bean.Demo;
import com.star.springboot.bmp.activiti.persistence.dao.IDemoDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoDaoImpl extends BaseDaoImpl<Demo, Long> implements IDemoDao, InitializingBean {

    private static final String namespace = "Demo";
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void afterPropertiesSet() throws Exception {
        super.setStatement(namespace, sqlSessionTemplate);
    }
}
