package com.ttn.EcommerceProject.EcommerceProject.Co;

import com.ttn.EcommerceProject.EcommerceProject.Enums.AddressLabel;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellerRegistrationCo extends CustomerRegistrationCo{

    private String gst;
    private String companyName;
    private String city;
    private String state;
    private String country;
    private String addressLine;
    private Long zipCode;
    private AddressLabel label;

}
