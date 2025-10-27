package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bank")
public class StarBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarBankApplication.class, args);
	}

}
