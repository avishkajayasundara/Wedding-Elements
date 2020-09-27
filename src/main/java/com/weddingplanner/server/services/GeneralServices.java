package com.weddingplanner.server.services;

public interface GeneralServices {
    void add(Object object);
    void removeById(String id);
    Object retrieveById(String id);
}
