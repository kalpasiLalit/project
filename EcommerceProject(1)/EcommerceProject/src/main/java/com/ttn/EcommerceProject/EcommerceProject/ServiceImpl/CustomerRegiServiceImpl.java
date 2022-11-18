package com.ttn.EcommerceProject.EcommerceProject.ServiceImpl;

import com.ttn.EcommerceProject.EcommerceProject.Service.EmailSenderService;
import com.ttn.EcommerceProject.EcommerceProject.Repository.UserRepository;
import com.ttn.EcommerceProject.EcommerceProject.Service.CustomerRegistrationService;
import com.ttn.EcommerceProject.EcommerceProject.Co.CustomerRegistrationCo;
import com.ttn.EcommerceProject.EcommerceProject.model.Customer;
import com.ttn.EcommerceProject.EcommerceProject.model.Role;
import com.ttn.EcommerceProject.EcommerceProject.model.User;
import com.ttn.EcommerceProject.EcommerceProject.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerRegiServiceImpl implements CustomerRegistrationService {


    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
     @Autowired
     TokenService tokenService;

     @Autowired
     EmailSenderService emailSender;
//     @Autowired
//    JavaMailSender javaMailSender;
    @Override
    public String addCustomer(CustomerRegistrationCo registrationCo) {
        User user = new User();
        user.setFirstName(registrationCo.getFirstName());
        user.setMiddleName(registrationCo.getMiddleName());
        user.setLastName(registrationCo.getLastName());
        Optional<User> users = userRepository.findByEmail(registrationCo.getEmail());
      // Optional user1 = users.stream().filter(u -> u.getEmail().equals(registrationCo.getEmail())).findFirst();
        if(users.isPresent()){
            return  "email address already exists";
        }
        user.setEmail(registrationCo.getEmail());
        String password = registrationCo.getPassword();
        if (registrationCo.getConfirmPassword().equals(password)) {
            user.setPassword(passwordEncoder.encode(registrationCo.getPassword()));
            user.setPasswordUpdateTime(LocalDateTime.now());
            user.setIsActive(false);
            user.setInvalidAttemptCount(0);
            user.setIsExpired(false);
            user.setIsDeleted(false);
            user.setIsLocked(false);
            Customer customer = new Customer();
            customer.setContact(registrationCo.getPhoneNumber());
            customer.setUser(user);
            user.setCustomer(customer);
            Role role = new Role();
            role.setAuthority("ROLE_CUSTOMER");
            user.setRole(role);


            String token = tokenService.generateToken(user);

            String link = "http://localhost:8080/user/confirm/"+token;
            //send(sentTo, template(bulid(first name,link)) used to send email
            emailSender.send(registrationCo.getEmail(), tokenService.buildEmail(registrationCo.getFirstName(), link));
            userRepository.save(user);
            return
                    "Customer Registered Successfully!\n activation link has been sent to your gmail account";


        } else {
            return "password doesn't match";
        }


    }


}
