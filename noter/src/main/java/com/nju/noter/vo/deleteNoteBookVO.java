package com.nju.noter.vo;

public class deleteNoteBookVO {
    int ID;
    String bookname;
    int userId;

    public deleteNoteBookVO(int ID, String bookname, int userId) {
        this.ID = ID;
        this.bookname = bookname;
        this.userId = userId;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
