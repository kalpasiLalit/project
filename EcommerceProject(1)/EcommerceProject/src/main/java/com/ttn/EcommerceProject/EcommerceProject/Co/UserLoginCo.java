package com.ttn.EcommerceProject.EcommerceProject.Co;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserLoginCo {
    @NotNull(message = "email can not be null")
    @Email(message = "email is not valid")
    private String email;
    private String password;
}
