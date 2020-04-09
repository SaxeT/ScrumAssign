package com.nju.noter.vo;

public class DeleteNoteBookVO {
    int id;
    String bookname;
    int userId;

    public DeleteNoteBookVO(int id, String bookname, int userId) {
        this.id = id;
        this.bookname = bookname;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
