package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "manufacturemsloadbal", configuration = CustomLoadBalancerAlgo.class)
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class ManufacturerMSLoadBal {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturerMSLoadBal.class, args);
	}
}
