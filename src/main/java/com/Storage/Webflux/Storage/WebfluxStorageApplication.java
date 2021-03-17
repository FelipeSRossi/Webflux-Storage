package com.Storage.Webflux.Storage;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class WebfluxStorageApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebfluxStorageApplication.class, args);
		System.out.println("Webflux API");
	}

}
