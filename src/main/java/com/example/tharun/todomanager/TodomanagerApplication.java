package com.example.tharun.todomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.example.tharun.todomanager.repository")
public class TodomanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodomanagerApplication.class, args);
	}

}
	