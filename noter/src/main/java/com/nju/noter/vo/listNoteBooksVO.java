package com.nju.noter.vo;

public class listNoteBooksVO {
    int userId;

    public listNoteBooksVO(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
