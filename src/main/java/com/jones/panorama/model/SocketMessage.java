package com.jones.panorama.model;

/**
 * Created by jones on 18-1-22.
 */
public class SocketMessage {
    private Object message;
    private String date;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
