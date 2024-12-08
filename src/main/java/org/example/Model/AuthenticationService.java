package org.example.Model;

import Util.DataBaseUtil;

import java.util.*;

public class AuthenticationService {
    private static final Map<String, User> users = new HashMap<>();

    public static boolean managerLogin(String username, String password) {
        if (username.equals("Manager") && password.equals("Manager")) {
            System.out.println("Login successful");
            return true;
        }
        return false;
    }

    public static boolean customerLogin(String username, String password) {
        List<Customer> customers = DataBaseUtil.getAllCustomers();
        for (Customer customer : customers) {
            if (customer.getUserName().equals(username) && customer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    public static boolean register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = sc.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists");
            return false;
        }

        System.out.println("Enter password:");
        String password = sc.nextLine();

        System.out.println("Enter email:");
        String email = sc.nextLine();

        User newUser = new Customer(username, password);

        users.put(username, newUser);
        System.out.println("New Customer created");
        return true;
    }
}
