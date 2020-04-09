package com.nju.noter.vo;

public class ModfiyNoteBookVO {
    int id;
    String oldBookname;
    String newBookname;
    String oldDescription;
    String newDescription;
    int userId;

    public ModfiyNoteBookVO(int id, String oldBookname, String newBookname, String oldDescription, String newDescription, int userId) {
        this.id = id;
        this.oldBookname = oldBookname.trim();
        this.newBookname = newBookname.trim();
        this.oldDescription = oldDescription.trim();
        this.newDescription = newDescription.trim();
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOldBookname() {
        return oldBookname;
    }

    public void setOldBookname(String oldBookname) {
        this.oldBookname = oldBookname;
    }

    public String getNewBookname() {
        return newBookname;
    }

    public void setNewBookname(String newBookname) {
        this.newBookname = newBookname;
    }

    public String getOldDescription() {
        return oldDescription;
    }

    public void setOldDescription(String oldDescription) {
        this.oldDescription = oldDescription;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
