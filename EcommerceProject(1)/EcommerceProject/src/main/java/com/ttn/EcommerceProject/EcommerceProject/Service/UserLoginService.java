package com.ttn.EcommerceProject.EcommerceProject.Service;

import com.ttn.EcommerceProject.EcommerceProject.model.User;

import java.util.Optional;

public interface UserLoginService {
    String userLogin(String email,String password);
}

