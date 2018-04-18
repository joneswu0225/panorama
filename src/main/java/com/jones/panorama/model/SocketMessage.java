package com.jones.panorama.model;

public class SocketMessage {
    private Object message;
    private String date;

    public SocketMessage() {
    }

    public SocketMessage(Object message, String date) {
        this.message = message;
        this.date = date;
    }

    public Object getMessage() {
        return this.message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
