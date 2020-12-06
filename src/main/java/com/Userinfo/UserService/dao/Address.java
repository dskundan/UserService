package com.Userinfo.UserService.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "user_id")
    private String id;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postcode")
    private String postCode;

    public Address() {

    }

    public Address(String id, String street, String city, String state, String postCode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }
}
