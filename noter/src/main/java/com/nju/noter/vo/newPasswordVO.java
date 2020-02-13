package com.nju.noter.vo;

public class newPasswordVO {
    int ID;
    String oldPassword;
    String newPassword;

    public newPasswordVO(int ID, String oldPassword, String newPassword) {
        this.ID = ID;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
