package org.example.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthenticationService {
    private static final Map<String, User> users = new HashMap<>();

    public static boolean login(String username, String password) {
        User user = users.get(username);

        if (user == null) {
            System.out.println("Invalid username not found");
            return false;
        }

        if (!user.getPassword().equals(password)) {
            System.out.println("Invalid password");
            return false;
        }

        System.out.println("Login successful");
        return true;
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

        User newUser = new Customer(username, password, email);

        users.put(username, newUser);
        System.out.println("New Customer created");
        return true;
    }
}
