package com.ttn.EcommerceProject.EcommerceProject.Controller;

import com.ttn.EcommerceProject.EcommerceProject.Co.CustomerRegistrationCo;
import com.ttn.EcommerceProject.EcommerceProject.Co.SellerRegistrationCo;
import com.ttn.EcommerceProject.EcommerceProject.Service.SellerRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/seller")
public class SellerRegister {
    @Autowired
    SellerRegistrationService sellerRegistrationService;

    @PostMapping(path = "/signUp")
    public ResponseEntity<Object> registration( @RequestBody SellerRegistrationCo sellerRegistrationCo){
        String message = sellerRegistrationService.addSeller(sellerRegistrationCo);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
