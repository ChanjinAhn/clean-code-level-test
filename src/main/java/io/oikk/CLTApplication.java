package io.oikk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CLTApplication {

	public static void main(String[] args) {
		SpringApplication.run(CLTApplication.class, args);
	}


}
