package com.sysco.ordermanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
public class OrderManagerApplication {

	private static Logger logger = LoggerFactory.getLogger(OrderManagerApplication.class);

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderManagerApplication.class, args);
		logger.info("---------------- Starting the Spring Boot Application -----------------");
	}
}
