package com.mycompany.entity;

public class AdminLogin {
    public int id;
    public String loginEmail;
    public String loginpassword;

    public AdminLogin() {
    }

    public AdminLogin(int id, String loginEmail, String loginpassword) {
        this.id = id;
        this.loginEmail = loginEmail;
        this.loginpassword = loginpassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword;
    }

    @Override
    public String toString() {
        return "AdminLogin{" +
                "id=" + id +
                ", loginEmail='" + loginEmail + '\'' +
                ", loginpassword='" + loginpassword + '\'' +
                '}';
    }
}
