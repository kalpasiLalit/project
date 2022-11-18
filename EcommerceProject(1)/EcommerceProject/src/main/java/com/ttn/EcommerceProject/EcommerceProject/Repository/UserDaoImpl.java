package com.ttn.EcommerceProject.EcommerceProject.Repository;

import com.ttn.EcommerceProject.EcommerceProject.configuration.AppUser;
import com.ttn.EcommerceProject.EcommerceProject.configuration.GrantAuthorityImpl;
import com.ttn.EcommerceProject.EcommerceProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;


    @Override
    public AppUser loadByUsername(String userName) {
        User user = userRepository.findUserByEmail(userName);
        if (user != null) {
            return new AppUser(user.getEmail(), user.getPassword(), Arrays.asList(new GrantAuthorityImpl(user.getRole().toString())));
        } else
            throw new RuntimeException();
    }
}