package com.ttn.EcommerceProject.EcommerceProject.Controller;

import com.ttn.EcommerceProject.EcommerceProject.Co.UserLoginCo;
import com.ttn.EcommerceProject.EcommerceProject.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserLoginService userLoginService;

    @PostMapping(path = "/signIn")
    public ResponseEntity<Object> customerLogin(@Valid  @RequestBody UserLoginCo customerLoginCo){

        String message = userLoginService.userLogin(customerLoginCo.getEmail(),customerLoginCo.getPassword());
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
