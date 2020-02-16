package com.nju.noter.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @Column(name = "id")
    private int ID;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "category")
    private String category;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "uid")
    private int UID;

    @Column(name = "nbid")
    private int NBID;

    public Note(String title, String content, String category, int UID, int NBID) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.UID = UID;
        this.NBID = NBID;
    }

    public Note(int ID, String title, String content, String category, int UID, int NBID) {
        this.ID = ID;
        this.title = title;
        this.content = content;
        this.category = category;
        this.UID = UID;
        this.NBID = NBID;
    }

    public Note() {
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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

    @Override
    public String toString() {
        return "Note{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", time=" + time +
                ", UID=" + UID +
                ", NBID=" + NBID +
                '}';
    }
}
