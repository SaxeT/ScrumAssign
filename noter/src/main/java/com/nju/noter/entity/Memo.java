package com.nju.noter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "memo")
public class Memo {
    @Id
    @Column(name = "id")
    private int ID;

    @Id
    @Column(name = "title")
    private String title;

    @Id
    @Column(name = "date")
    private Date date;

    @Id
    @Column(name = "content")
    private String content;

    public Memo() {
    }

    public Memo(int ID, String title, Date date, String content) {
        this.ID = ID;
        this.title = title;
        this.date = date;
        this.content = content;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
