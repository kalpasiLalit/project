package com.ttn.EcommerceProject.EcommerceProject.ServiceImpl;

import com.ttn.EcommerceProject.EcommerceProject.Repository.ConfirmationTokenRepository;
import com.ttn.EcommerceProject.EcommerceProject.Service.EmailSenderService;
import com.ttn.EcommerceProject.EcommerceProject.Service.ResendTokenService;
import com.ttn.EcommerceProject.EcommerceProject.Service.TokenService;
import com.ttn.EcommerceProject.EcommerceProject.model.ConfirmationToken;
import com.ttn.EcommerceProject.EcommerceProject.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ResendTokenServiceImpl implements ResendTokenService {

    @Autowired
    private TokenService tokenService;

     @Autowired
     private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @Override
    public ResponseEntity<Object> resendEmail(User user) {
            String token = tokenService.generateToken(user);
            String link = "http://localhost:8080/user/confirm/"+token;
            try {
                emailSenderService.send(user.getEmail(), tokenService.buildEmail(user.getFirstName(), link));
            }catch(Exception exception               ){
                log.error("Mial senddddddddddddddddddder errrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrroe",exception);
            }



        return new ResponseEntity<>("token has been send", HttpStatus.OK);


    }
}
