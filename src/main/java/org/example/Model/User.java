package org.example.Model;

import java.util.Scanner;

public abstract class User {
    protected String userName;
    protected String password;
    protected String email;

    public User() {}

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password)) {
            this.password = newPassword;
            System.out.println("Password changed successfully.");
            return true;
        } else {
            System.out.println("Incorrect old password. Password change failed.");
            return false;
        }
    }
}
