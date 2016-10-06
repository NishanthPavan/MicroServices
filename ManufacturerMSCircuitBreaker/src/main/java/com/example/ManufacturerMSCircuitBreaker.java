package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

import com.example.dao.ManufacturerMSFeignClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = ManufacturerMSFeignClient.class)
@EnableHypermediaSupport(type = HypermediaType.HAL)
@EnableHystrix
@EnableTurbine
public class ManufacturerMSCircuitBreaker {
	public static void main(String[] args) {
		SpringApplication.run(ManufacturerMSCircuitBreaker.class, args);
	}
}
