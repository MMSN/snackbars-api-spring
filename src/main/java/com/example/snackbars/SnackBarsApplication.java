package com.example.snackbars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.example"})
//@EntityScan("com.example")
//@EnableJpaRepositories("com.example")
public class SnackBarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnackBarsApplication.class, args);
	}

}
