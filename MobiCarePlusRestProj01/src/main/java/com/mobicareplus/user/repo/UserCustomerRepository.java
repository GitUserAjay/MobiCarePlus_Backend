package com.mobicareplus.user.repo;

import com.mobicareplus.user.model.UserCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCustomerRepository extends JpaRepository<UserCustomer, Long> {
}