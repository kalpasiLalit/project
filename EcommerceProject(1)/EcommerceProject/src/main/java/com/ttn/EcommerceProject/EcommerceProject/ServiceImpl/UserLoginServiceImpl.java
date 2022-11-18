package com.ttn.EcommerceProject.EcommerceProject.ServiceImpl;

import com.ttn.EcommerceProject.EcommerceProject.Repository.UserRepository;
import com.ttn.EcommerceProject.EcommerceProject.Service.UserLoginService;
import com.ttn.EcommerceProject.EcommerceProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    int totalAttempt = 3;

    @Override
    public String userLogin(String email, String password) {

        Optional<User> users = userRepository.findByEmail(email);
        String password1 = users.get().getPassword();
        Integer count = users.get().getInvalidAttemptCount();
         if(users.get().getIsLocked().equals(false)) {
             if (users.isEmpty()) {
                 return "email not exists";
             } else if (passwordEncoder.matches(password, password1)) {
                 return "login succecfully";
             } else {
                 if (count > 3) {
                     userRepository.updateIsLocked(users.get().getEmail(), true);
                     return "your account has been blocked";
                 } else {
                     userRepository.invalidAttemptCount(users.get().getEmail(), count + 1);
                     return "credentials are not valid you have " + totalAttempt-- + " attempt left ";
                 }
             }
         }
         return "your account is locked by admin";
    }
}
