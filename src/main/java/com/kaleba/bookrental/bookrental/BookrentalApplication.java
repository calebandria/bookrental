package com.kaleba.bookrental.bookrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.kaleba.bookrental.bookrental")
public class BookrentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookrentalApplication.class, args);
	}

}
