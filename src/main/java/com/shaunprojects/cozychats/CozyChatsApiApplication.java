package com.shaunprojects.cozychats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CozyChatsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CozyChatsApiApplication.class, args);
	}

}
