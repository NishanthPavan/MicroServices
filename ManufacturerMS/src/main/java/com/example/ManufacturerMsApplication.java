package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories("com.example.repository")
public class ManufacturerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturerMsApplication.class, args);
	}
}
