package com.ttn.EcommerceProject.EcommerceProject.Service;

public interface EmailSenderService {
    void send(String  to, String emailTemplate);
}