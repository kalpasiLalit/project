package com.ttn.EcommerceProject.EcommerceProject.configuration;


import com.ttn.EcommerceProject.EcommerceProject.Repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDaoImpl userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String encryptedPassword = passwordEncoder.encode("password");
        System.out.println("usernName" + username);
        System.out.println("Password" + encryptedPassword);
        UserDetails userDetails = userDao.loadByUsername(username);
        return userDetails;
    }
}