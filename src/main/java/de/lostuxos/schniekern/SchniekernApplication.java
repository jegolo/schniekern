package de.lostuxos.schniekern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SchniekernApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchniekernApplication.class, args);
	}

}
