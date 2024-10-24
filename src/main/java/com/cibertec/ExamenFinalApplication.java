package com.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class ExamenFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenFinalApplication.class, args);
	}

}
