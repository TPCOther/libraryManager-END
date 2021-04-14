package com.library.entity;

public class user {
    private String name;
    private int UID;
    private String pwd;
    
    public void setName(String name) {
        this.name = name;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public void setpwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public int getUID() {
        return UID;
    }

    public boolean login(String pwd) {
        if(pwd == this.pwd) {return true;}
        else {return false;}
    }
}
