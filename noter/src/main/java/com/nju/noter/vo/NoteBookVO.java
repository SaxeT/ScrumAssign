package com.nju.noter.vo;

public class NoteBookVO {
    String bookname;
    String description;
    int userId;

    public NoteBookVO() {

    }

    public NoteBookVO(int userId) {
        this.userId = userId;
    }

    public NoteBookVO(String bookname, String description, int userId) {
        this.bookname = bookname.trim();
        this.description = description.trim();
        this.userId = userId;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
