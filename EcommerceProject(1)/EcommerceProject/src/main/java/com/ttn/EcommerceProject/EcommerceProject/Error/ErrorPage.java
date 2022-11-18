package com.ttn.EcommerceProject.EcommerceProject.Error;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorPage {
    private LocalDateTime localDateTime;
    private List<String> message;
    private  String Details;

    public ErrorPage(LocalDateTime localDateTime, List<String> message, String details) {
        this.localDateTime = localDateTime;
        this.message = message;
        Details = details;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }
}