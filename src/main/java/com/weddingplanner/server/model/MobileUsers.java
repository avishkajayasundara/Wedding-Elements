package com.weddingplanner.server.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MobileUsers {
    @Id
    String email;
    String instanceId;

    public MobileUsers(String email, String instanceId) {
        this.email = email;
        this.instanceId = instanceId;
    }

    public MobileUsers() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

}
