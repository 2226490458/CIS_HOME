package com.example.demo.common;

import java.util.Date;

/**
 * @author 青菜白玉堂
 * @create 2021-06-16
 */
public class CommonResult<T> {
    private Date timestamp;
    private Integer status;
    private T data;
    private String message;
    private String error;
    public CommonResult(Date timestamp, Integer status) {
        this.timestamp = timestamp;
        this.status = status;
    }
    public CommonResult(String message) {
        this.timestamp = new Date();
        this.status = 200;
        this.message = message;
        this.data = null;
    }
    public static CommonResult<Object> success(String message) {
        return new CommonResult<>(message);
    }


    public static CommonResult<Object> success(Object data) {
        CommonResult<Object> result = new CommonResult<>(new Date(), 200);
        result.setData(data);
        return result;
    }

    public static CommonResult<Object> fail(String message) {
        CommonResult<Object> result = new CommonResult<>(new Date(), 415);
        result.setMessage(message);
        return result;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}