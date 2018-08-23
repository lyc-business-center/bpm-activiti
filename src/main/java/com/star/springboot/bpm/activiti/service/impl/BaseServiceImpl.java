package com.star.springboot.bpm.activiti.service.impl;

import com.star.springboot.bpm.activiti.constant.CoreCodeConsts;
import com.star.springboot.bpm.activiti.exception.BusinessException;
import com.star.springboot.bpm.activiti.persistence.dao.IBaseDao;
import com.star.springboot.bpm.activiti.service.IBaseService;

import java.util.List;

public class BaseServiceImpl<T,R> implements IBaseService<T, R> {

    IBaseDao<T, R> baseDao;

    @Override
    public T save(T t) {
        Integer res = baseDao.insert(t);
        if (res == null || res <= 0) {
            throw new BusinessException(CoreCodeConsts.REQUEST_PROGRAM_ERROR_CODE,
                    t.getClass().getSimpleName()+"保存失败", false);
        }
        return t;
    }

    @Override
    public T update(T t) {
        Integer rst = baseDao.update(t);
        if(rst <= 0){
            throw new BusinessException(CoreCodeConsts.REQUEST_PROGRAM_ERROR_CODE,
                    t.getClass().getSimpleName()+"修改失败", false);
        }
        return t;
    }

    @Override
    public Integer delete(R r) {
        return baseDao.delete(r);
    }

    @Override
    public T get(R r) {

        return baseDao.get(r);
    }

    @Override
    public List<T> getList(T t) {
        return baseDao.getList(t);
    }

    @Override
    public List<T> getListWithPage(T t, Integer curPage, Integer pageSize) {
        if(curPage < 1) curPage = 1;
        return baseDao.getListWithPage(t, (curPage-1)*pageSize, pageSize);
    }

    @Override
    public long count(T t) {
        return baseDao.count(t);
    }

    public void setDao(IBaseDao<T, R> baseDao){
        this.baseDao = baseDao;
    }
}
