package com.bookonline.managedbean;

import javax.inject.Inject;
import com.bookonline.entities.User;
import com.bookonline.sessions.UserManagement;

public class UserManagementBean {

    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private boolean isAdmin;

    @Inject
    private UserManagement userManagement;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public UserManagement getUserManagement() {
        return userManagement;
    }

    public void setUserManagement(UserManagement userManagement) {
        this.userManagement = userManagement;
    }

    public String register() {
        User newUser = new User(name, email, address, password, isAdmin);
        userManagement.registerUser(newUser);
        return "login";
    }

    public String login() {
        boolean loggedIn = userManagement.login(username, password);
        if (loggedIn) {
            return "welcome"; 
        } else {
            return "login";
        }
    }

}

