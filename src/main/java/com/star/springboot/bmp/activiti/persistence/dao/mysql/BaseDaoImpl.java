package com.star.springboot.bmp.activiti.persistence.dao.mysql;

import com.star.springboot.bmp.activiti.persistence.dao.IBaseDao;
import com.star.springboot.bmp.activiti.util.ObjectUtils;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

public class BaseDaoImpl<T, R> implements IBaseDao<T , R> {

    String namespace;
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Integer insert(T t) {
        return sqlSessionTemplate.insert(namespace + ".insert", t);
    }

    @Override
    public Integer update(T t) {
        return sqlSessionTemplate.update(namespace + ".update", t);
    }

    @Override
    public Integer delete(R r) {
        return sqlSessionTemplate.delete(namespace + ".delete", r);
    }

    @Override
    public T get(R r) {
        return sqlSessionTemplate.selectOne(namespace + ".get", r);
    }

    @Override
    public List<T> getList(T t) {
        return sqlSessionTemplate.selectList(namespace + ".getList", t);
    }

    @Override
    public List<T> getListWithPage(T t, long startRow, Integer pageSize) {

        Map<String, Object> option = ObjectUtils.covertMap(t);
        option.put("startRow", startRow);
        option.put("pageSize", pageSize);

        return sqlSessionTemplate.selectList(namespace + ".getListWithPage", option);
    }

    @Override
    public long count(T t) {
        return sqlSessionTemplate.selectOne(namespace + ".count", t);
    }

    /** 需要实现类设置 namespace 及 sqlSessionTemplate **/
    public void setStatement(String namespace, SqlSessionTemplate sqlSessionTemplate){
        this.namespace = namespace;
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

}
