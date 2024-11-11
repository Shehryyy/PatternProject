package org.example.Model;

public class Customer extends User {

    public Customer() {
    }

    public Customer(String userName, String password, String email, Role role) {
        super(userName, password, email, role);
    }
}
