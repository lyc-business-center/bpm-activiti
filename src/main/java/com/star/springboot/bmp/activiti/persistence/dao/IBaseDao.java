package com.star.springboot.bmp.activiti.persistence.dao;

import java.util.List;

public interface IBaseDao<T, R>{

    Integer insert(T t);

    Integer update(T t);

    Integer delete(R r);

    T get(R r);

    List<T> getList(T t);

    List<T> getListWithPage(T t, long startRow, Integer pageSize);

    long count(T t);

}
