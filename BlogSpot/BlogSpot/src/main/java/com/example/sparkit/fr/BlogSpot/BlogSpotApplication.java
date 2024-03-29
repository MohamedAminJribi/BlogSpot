package com.example.sparkit.fr.BlogSpot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BlogSpotApplication {

	public static void main(String[] args)  throws Exception {
		SpringApplication.run(BlogSpotApplication.class, args);
	}

}
