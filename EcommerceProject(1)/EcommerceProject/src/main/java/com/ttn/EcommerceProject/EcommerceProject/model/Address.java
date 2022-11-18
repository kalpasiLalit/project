package com.ttn.EcommerceProject.EcommerceProject.model;


import com.ttn.EcommerceProject.EcommerceProject.Enums.AddressLabel;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String state;
    private String country;
    private String addressLine;
    private Long zipCode;
    private AddressLabel label;

    // mapping
    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;



}
