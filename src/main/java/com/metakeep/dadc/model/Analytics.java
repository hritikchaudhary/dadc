package com.metakeep.dadc.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Entity
@Table(name = "analytics")
public class Analytics {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Id
    public String id;
    @Column(name = "timestamp")
    private Date createdAt;
    @Column(name = "user_id")
    private String userID;

    @Column(name = "status")
    private HttpStatus status;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "request")
    private String request;

    @Column(name = "response")
    private String response;

}
