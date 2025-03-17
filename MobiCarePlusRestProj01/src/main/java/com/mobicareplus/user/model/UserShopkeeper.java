package com.mobicareplus.user.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "User_Shopkeeper")
public class UserShopkeeper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopkeeperID;

    @Column(nullable = false)
    private Long userID;

    private String name;
    private String contactNumber;
    private String address;

    @Column(nullable = true) // Optional field
    private String profileImage;

    @Column(nullable = true) // Optional field
    private String shopDescription;
}