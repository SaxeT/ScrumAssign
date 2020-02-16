package com.nju.noter.vo;

public class NoteVO {
    private int ID = -1;
    private String title;
    private String content;
    private String category;
    private int UID;
    private int NBID;

    public NoteVO(String title, String content, String category, int UID, int NBID) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.UID = UID;
        this.NBID = NBID;
    }

    public NoteVO(int ID, String title, String content, String category, int UID, int NBID) {
        this.ID = ID;
        this.title = title;
        this.content = content;
        this.category = category;
        this.UID = UID;
        this.NBID = NBID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getNBID() {
        return NBID;
    }

    public void setNBID(int NBID) {
        this.NBID = NBID;
    }
}
