package com.retail.management.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.retail.management.model.ResponseMessage;

@SpringBootApplication(scanBasePackages={"com.retail.management"})
@EnableJpaRepositories(basePackages = "com.retail.management")
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan("com.retail.management.*")

public class RetailManagementService {
	public static void main(String[] args) {		
		SpringApplication.run(RetailManagementService.class, args);
	}
	@Bean
	public ResponseMessage getResponseMessage(){
		return new ResponseMessage();
	}
	
	
}
