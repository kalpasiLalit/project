package com.ttn.EcommerceProject.EcommerceProject.Repository;


import com.ttn.EcommerceProject.EcommerceProject.configuration.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    AppUser loadByUsername(String userName);
}