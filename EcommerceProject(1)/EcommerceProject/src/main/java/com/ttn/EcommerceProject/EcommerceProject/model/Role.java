package com.ttn.EcommerceProject.EcommerceProject.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    private String authority;

//    @ManyToMany(mappedBy = "roleSet")
//    private Set<User> user;


}
