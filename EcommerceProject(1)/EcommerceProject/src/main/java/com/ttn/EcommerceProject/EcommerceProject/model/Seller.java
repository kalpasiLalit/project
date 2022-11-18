package com.ttn.EcommerceProject.EcommerceProject.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sellerId;
    private String GST;
    private String companyContact;
    private String companyName;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;



}
