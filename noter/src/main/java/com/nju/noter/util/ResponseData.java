package com.nju.noter.util;

public class ResponseData<T> {

    private boolean result;

    private String message;

    private T data;

    public ResponseData() {}

    public ResponseData(boolean result) {
        this.result = result;
    }

    public ResponseData(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public ResponseData(boolean result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
