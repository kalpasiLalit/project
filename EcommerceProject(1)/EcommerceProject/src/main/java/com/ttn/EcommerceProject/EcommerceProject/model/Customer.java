package com.ttn.EcommerceProject.EcommerceProject.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    //mapping
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
    private String contact;

}
