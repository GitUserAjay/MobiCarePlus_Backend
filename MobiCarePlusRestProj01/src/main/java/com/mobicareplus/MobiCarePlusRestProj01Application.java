package com.mobicareplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MobiCarePlusRestProj01Application {
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}

	public static void main(String[] args) {
		SpringApplication.run(MobiCarePlusRestProj01Application.class, args);
	}

}
