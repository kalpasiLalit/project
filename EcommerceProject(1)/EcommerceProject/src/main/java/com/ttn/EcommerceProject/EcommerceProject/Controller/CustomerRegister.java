package com.ttn.EcommerceProject.EcommerceProject.Controller;

import com.ttn.EcommerceProject.EcommerceProject.Co.CustomerRegistrationCo;
import com.ttn.EcommerceProject.EcommerceProject.Service.CustomerRegistrationService;
import com.ttn.EcommerceProject.EcommerceProject.Service.UserLoginService;
import com.ttn.EcommerceProject.EcommerceProject.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class CustomerRegister {
    @Autowired
    CustomerRegistrationService customerRegistrationService;
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    TokenService tokenService;

    @PostMapping(path = "/signUp")
    public ResponseEntity<Object> registration(@Valid @RequestBody CustomerRegistrationCo registrationCo){
        String message = customerRegistrationService.addCustomer(registrationCo);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(path = "/confirm/{token}")
    public String confirm(@PathVariable String token) {
        return tokenService.confirmToken(token);
    }


    @GetMapping("/getUser")
    public  String customServices(){
        return "services for customer";
    }


}
