package com.weddingplanner.server.exceptions;

public class Exception extends Throwable {
    int code;
    Throwable cause;
    String Message;

    public Exception(int code, Throwable cause, String message) {
        this.code = code;
        this.cause = cause;
        Message = message;
    }

    public Exception(int code, String message) {
        this.code = code;
        Message = message;
    }

    public Exception() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
