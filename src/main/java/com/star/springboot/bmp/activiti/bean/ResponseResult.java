package com.star.springboot.bmp.activiti.bean;

public class ResponseResult<T> extends BaseBean {
    private Integer code;
    private String message;
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(T data) {
        this(0, "成功", data);
    }

    public ResponseResult(Integer code, String message) {
        this(code, message, (T)null);
    }

    public ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult(data);
    }

    public static <T> ResponseResult<T> fail(Integer code, String message, T data) {
        return new ResponseResult(code, message, data);
    }

    public static <T> ResponseResult<T> fail(Integer code, String message) {
        return new ResponseResult(code, message);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean success() {
        return this.code == 0;
    }
}
