
package com.star.springboot.bmp.activiti.context;

import javax.servlet.http.HttpServletRequest;

public class RequestThreadLocal {
    public static ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal();

    public RequestThreadLocal() {
    }

    public static void removeRequest() {
        threadLocal.remove();
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest)threadLocal.get();
    }

    public static void setRequest(HttpServletRequest req) {
        threadLocal.set(req);
    }
}
