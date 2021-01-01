package com.weddingplanner.server.model.mobileDTO;

public class LoggedInUser {
    private String username,userRole;

    public LoggedInUser(String username, String userRole) {
        this.username = username;
        this.userRole = userRole;
    }

    public LoggedInUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
