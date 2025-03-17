package com.mobicareplus.user.service;

import com.mobicareplus.user.dto.AuthResponse;
import com.mobicareplus.user.dto.LoginRequest;
import com.mobicareplus.user.dto.SignupRequest;
import com.mobicareplus.user.model.User;
import com.mobicareplus.user.model.UserCustomer;
import com.mobicareplus.user.model.UserShopkeeper;
import com.mobicareplus.user.repo.UserRepository;
import com.mobicareplus.user.repo.UserCustomerRepository;
import com.mobicareplus.user.repo.UserShopkeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;
import java.time.LocalDateTime;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCustomerRepository userCustomerRepository;

    @Autowired
    private UserShopkeeperRepository userShopkeeperRepository;

    public AuthResponse signup(SignupRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return new AuthResponse("Email already exists!", false);
        }

        // Save user in User_User table
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setRole(request.getRole());
        user.setCreated_at(LocalDateTime.now());
        userRepository.save(user);

        // Save role-specific details
        if (request.getRole() == User.Role.CUSTOMER) {
            UserCustomer customer = new UserCustomer();
            customer.setUserID(user.getUserID());
            customer.setName(request.getName());
            customer.setContactNumber(request.getContactNumber());
            customer.setAddress(request.getAddress());
            customer.setProfileImage(null); // Initialize as null
            customer.setWishlist(null); // Initialize as null
            userCustomerRepository.save(customer);
        } else if (request.getRole() == User.Role.SHOPKEEPER) {
            UserShopkeeper shopkeeper = new UserShopkeeper();
            shopkeeper.setUserID(user.getUserID());
            shopkeeper.setName(request.getName());
            shopkeeper.setContactNumber(request.getContactNumber());
            shopkeeper.setAddress(request.getAddress());
            shopkeeper.setProfileImage(null); // Initialize as null
            shopkeeper.setShopDescription(null); // Initialize as null
            userShopkeeperRepository.save(shopkeeper);
        }

        return new AuthResponse("Signup successful!", true);
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if (!BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            return new AuthResponse("Invalid credentials!", false);
        }

        return new AuthResponse("Login successful!", true);
    }
}