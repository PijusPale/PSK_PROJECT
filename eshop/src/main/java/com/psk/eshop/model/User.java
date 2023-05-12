package com.psk.eshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.psk.eshop.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UserType userType;
    private String name;
    private String email;
    private String password;
    private String phoneNo;
    private String address;
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Order order;
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Refund refund;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Set<Product> products = new HashSet<>();
}
