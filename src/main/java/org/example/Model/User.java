package org.example.Model;

public abstract class User {
    protected String userName;
    protected String password;
    protected String email;
    protected Role role;

    public User() {
    }

    public User(String userName, String password, String email, Role role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
