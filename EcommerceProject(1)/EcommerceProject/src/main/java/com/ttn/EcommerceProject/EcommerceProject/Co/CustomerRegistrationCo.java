package com.ttn.EcommerceProject.EcommerceProject.Co;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationCo {


    @NotBlank(message = "email cannot be null")
    @Email(message = "email is not valid")
    private String email;

    @NotNull(message = "first name cannot be null")
    @Size(min = 2,max = 15,message = "First name should have atleast 2 character and maximum 15 character")
    private String firstName;

    private String middleName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 2,max = 15,message = "Last name should have atleast 2 character and maximum 15 character")
    private String lastName;

    @NotNull(message = "password cannot be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "8-15 Characters with atleast 1 Lower case, 1 Upper case, 1 Special Character, 1 Number")
    private String password;

    @NotNull(message = "confirm password cannot be empty")
    private String confirmPassword;

    @NotNull(message = "phone numder can not be empty")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Phone number must be of 10 digits")
    private String phoneNumber;

}
