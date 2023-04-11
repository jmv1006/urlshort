package com.github.jmv1006.urlshort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class UrlShortApplication {
	public static void main(String[] args) {
		SpringApplication.run(UrlShortApplication.class, args);
	}
}
