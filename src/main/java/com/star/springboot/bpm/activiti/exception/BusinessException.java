//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.star.springboot.bpm.activiti.exception;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1240015972592825169L;
    private boolean logged;
    private Integer errorCode = 0;
    private String errorDetailMsg;

    public BusinessException(String errMsg, boolean logged) {
        super(errMsg);
        this.logged = logged;
        this.errorDetailMsg = errMsg;
    }

    public BusinessException(Integer errorCode, String errMsg, boolean logged) {
        super(errMsg);
        this.logged = logged;
        this.errorCode = errorCode;
        this.errorDetailMsg = errMsg;
    }

    public BusinessException(Integer errorCode, String errMsg, String errorDetailMsg, boolean logged) {
        super(errMsg);
        this.logged = logged;
        this.errorCode = errorCode;
        this.errorDetailMsg = errorDetailMsg;
    }

    public BusinessException(String errMsg, Throwable throwable, boolean logged) {
        super(errMsg, throwable);
        this.logged = logged;
        this.errorDetailMsg = errMsg;
    }

    public BusinessException(Integer errorCode, String errMsg, Throwable throwable, boolean logged) {
        super(errMsg, throwable);
        this.logged = logged;
        this.errorCode = errorCode;
        this.errorDetailMsg = errMsg;
    }

    public BusinessException(Integer errorCode, String errMsg, String errorDetailMsg, Throwable throwable, boolean logged) {
        super(errMsg, throwable);
        this.logged = logged;
        this.errorCode = errorCode;
        this.errorDetailMsg = errorDetailMsg;
    }

    public boolean isLogged() {
        return this.logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDetailMsg() {
        return this.errorDetailMsg;
    }

    public void setErrorDetailMsg(String errorDetailMsg) {
        this.errorDetailMsg = errorDetailMsg;
    }
}
