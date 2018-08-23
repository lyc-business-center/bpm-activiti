package com.star.springboot.bpm.activiti.web.interceptor;

import com.star.springboot.base.bean.AuthContext;
import com.star.springboot.base.context.AuthContextThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by MaJingcao on 2018/3/14.
 * Copyright by syswin
 */
public class ApiAuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        AuthContext authContext = new AuthContext();
        //TODO: 构造authContext属性
        authContext.setUserId(1L);
        AuthContextThreadLocal.setAuthContext(authContext);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
