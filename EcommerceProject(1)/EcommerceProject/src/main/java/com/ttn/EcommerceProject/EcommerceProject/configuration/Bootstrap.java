package com.ttn.EcommerceProject.EcommerceProject.configuration;

import com.ttn.EcommerceProject.EcommerceProject.Repository.UserRepository;
import com.ttn.EcommerceProject.EcommerceProject.model.Role;
import com.ttn.EcommerceProject.EcommerceProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Component
public class Bootstrap implements ApplicationRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.count() < 1) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            User user1 = new User();
            user1.setFirstName("Sumit");
            user1.setMiddleName("");
            user1.setLastName("Gupta");
            user1.setPassword(passwordEncoder.encode("password"));
            user1.setEmail("Sumit123@gmail.com");
            user1.setIsActive(Boolean.TRUE);
            user1.setPasswordUpdateTime(LocalDateTime.now());
            user1.setInvalidAttemptCount(0);

            Role role = new Role();
            role.setAuthority("ROLE_ADMIN");
            user1.setRole(role);
             // user1.setRole("ROLE_ADMIN");
              userRepository.save(user1);


        }
    }
}