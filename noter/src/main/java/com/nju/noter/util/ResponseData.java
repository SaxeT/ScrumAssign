package com.nju.noter.util;

public class ResponseData<T> {

    private boolean result;

    private String message;

    private T data;

    public ResponseData() {
        this.result = true;
        this.message = "";
        this.data = null;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
