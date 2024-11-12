package org.example.Model;

import java.util.Scanner;

public abstract class User {
    protected String userName;
    protected String password;
    protected String email;
    protected Role role;

    public User() {
    }

    public User(String userName, String email, String password, Role role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your old password: ");
        String oldPassword = sc.nextLine();

        if (oldPassword.equals(this.password)) {
           this.password = password;
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Password does not match. Try Again.");
            oldPassword = sc.nextLine();

             if (oldPassword.equals(this.password)) {
                 this.password = oldPassword;
                 System.out.println("Password changed successfully.");
             } else {
                 System.out.println("Password change failed.");
             }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
