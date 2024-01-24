package com.bryanlema.springboot.error.models;

import java.util.Date;

public class Error {

    private String error;
    private String message;
    private int status;
    private Date date;

    

    public Error(String error, String message, int status, Date date) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.date = date;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    
}
