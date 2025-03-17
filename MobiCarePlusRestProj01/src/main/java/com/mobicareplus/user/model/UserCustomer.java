package com.mobicareplus.user.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "User_Customer")
public class UserCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;

    @Column(nullable = false)
    private Long userID;

    private String name;
    @Column(name ="ContactNumber")
    private String contactNumber;
    private String address;

    @Column(nullable = true) // Optional field
    private String profileImage;

    @Column(nullable = true) // Optional field
    private String wishlist;
}
