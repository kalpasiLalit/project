package com.ttn.EcommerceProject.EcommerceProject.ServiceImpl;

import com.ttn.EcommerceProject.EcommerceProject.Co.SellerRegistrationCo;
import com.ttn.EcommerceProject.EcommerceProject.Enums.AddressLabel;
import com.ttn.EcommerceProject.EcommerceProject.Repository.UserRepository;
import com.ttn.EcommerceProject.EcommerceProject.Service.EmailSenderService;
import com.ttn.EcommerceProject.EcommerceProject.Service.SellerRegistrationService;
import com.ttn.EcommerceProject.EcommerceProject.Service.TokenService;
import com.ttn.EcommerceProject.EcommerceProject.model.Address;
import com.ttn.EcommerceProject.EcommerceProject.model.Seller;
import com.ttn.EcommerceProject.EcommerceProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class SellerRegistrationServiceImpl implements SellerRegistrationService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private EmailSenderService emailSenderService;

    @Override
    public String addSeller(SellerRegistrationCo sellerRegistrationCo) {

        User user = new User();
        user.setFirstName(sellerRegistrationCo.getFirstName());
        user.setMiddleName(sellerRegistrationCo.getMiddleName());
        user.setLastName(sellerRegistrationCo.getLastName());
        Optional<User> users = userRepository.findByEmail(sellerRegistrationCo.getEmail());
        if (users.isPresent()) {
            return "email address already exists";
        }
        user.setEmail(sellerRegistrationCo.getEmail());
        user.setEmail(sellerRegistrationCo.getEmail());
        String password = sellerRegistrationCo.getPassword();
        if (sellerRegistrationCo.getConfirmPassword().equals(password)) {
            user.setPassword(passwordEncoder.encode(sellerRegistrationCo.getPassword()));
            user.setPasswordUpdateTime(LocalDateTime.now());
            user.setIsActive(false);
            user.setInvalidAttemptCount(0);
            user.setIsExpired(false);
            user.setIsDeleted(false);
            user.setIsLocked(false);

            //address field
            Set<Address> addressSet = new HashSet<>();
            Address address = new Address();
            address.setAddressLine(sellerRegistrationCo.getAddressLine());
            address.setCity(sellerRegistrationCo.getCity());
            address.setState(sellerRegistrationCo.getState());
            address.setLabel(sellerRegistrationCo.getLabel());
            address.setCountry(sellerRegistrationCo.getCountry());
            address.setZipCode(sellerRegistrationCo.getZipCode());
            AddressLabel lable = AddressLabel.OFFICE;
            address.setLabel(lable);
            address.setUser(user);
            addressSet.add(address);
            user.setAddressSet(addressSet);

            //seller field
            Seller seller = new Seller();
            seller.setGST(sellerRegistrationCo.getGst());
            seller.setCompanyName(sellerRegistrationCo.getCompanyName());
            seller.setCompanyContact(sellerRegistrationCo.getPhoneNumber());
            seller.setUser(user);
            user.setSeller(seller);

            //mail send
            String message = "your account has been created and yet to be approved by admin\n thank you for registration";
            //send(sentTo, template(bulid(first name,link)) used to send email
            emailSenderService.send(sellerRegistrationCo.getEmail(),message);
            userRepository.save(user);
            return "user registered succecfully";
        }
        return "password doesn't match";
    }
}
