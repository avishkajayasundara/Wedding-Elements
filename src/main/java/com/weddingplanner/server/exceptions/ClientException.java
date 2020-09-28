package com.weddingplanner.server.exceptions;

public class ClientException extends Exception {
    public ClientException(int code, String message) {
        super(code, message);
    }

    public ClientException() {
    }
}
