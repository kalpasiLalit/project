package com.ttn.EcommerceProject.EcommerceProject.Service;

import com.ttn.EcommerceProject.EcommerceProject.model.User;
import org.springframework.http.ResponseEntity;

public interface ResendTokenService {
    public ResponseEntity<Object> resendEmail(User user);
}
