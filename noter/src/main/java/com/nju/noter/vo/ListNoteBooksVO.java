package com.nju.noter.vo;

public class ListNoteBooksVO {
    int userId;

    public ListNoteBooksVO(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
