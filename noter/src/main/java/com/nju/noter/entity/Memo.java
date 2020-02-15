package com.nju.noter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@Entity
@Table(name = "memo")
public class Memo {
    @Id
    @Column(name = "id")
    private int ID;

    @Column(name = "title")
    private String title;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "content")
    private String content;

    @Column(name = "uid")
    private int UID;

    public Memo() {
    }

    public Memo(int ID, String title, Timestamp time, String content, int UID) {
        this.ID = ID;
        this.title = title;
        this.time = time;
        this.content = content;
        this.UID = UID;
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }
}
