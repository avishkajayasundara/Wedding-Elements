package com.weddingplanner.server.model.mobileDTO;

public class LoginRequest {
    String username;
    String password;
    String instanceId;

    public LoginRequest(String username, String password, String instanceId) {
        this.username = username;
        this.password = password;
        this.instanceId = instanceId;
    }

    public LoginRequest() {
    }

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

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

}
