package com.star.springboot.bmp.activiti.service;

import java.util.List;

public interface IBaseService<T, R> {

    T save(T t);

    T update(T t);

    Integer delete(R r);

    T get(R r);

    List<T> getList(T t);

    List<T> getListWithPage(T t, Integer curPage, Integer pageSize);

    long count(T t);

}
