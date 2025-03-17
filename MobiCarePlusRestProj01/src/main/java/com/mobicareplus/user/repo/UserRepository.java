package com.mobicareplus.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobicareplus.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findByEmail(String email);
	
	

}
