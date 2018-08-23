package com.star.springboot.bpm.activiti.context;

import javax.servlet.http.HttpServletResponse;

public class ResponseThreadLocal {
    public static ThreadLocal<HttpServletResponse> threadLocal = new ThreadLocal();

    public ResponseThreadLocal() {
    }

    public static void removeResponse() {
        threadLocal.remove();
    }

    public static HttpServletResponse getResponse() {
        return (HttpServletResponse)threadLocal.get();
    }

    public static void setResponse(HttpServletResponse res) {
        threadLocal.set(res);
    }
}