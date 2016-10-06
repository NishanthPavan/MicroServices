package com.example.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.model.Manufacturer;
import com.google.common.reflect.TypeToken;

@RestController
public class ManufacturerMSLoadBalController {

	@Autowired
	private LoadBalancerClient loadBalClient;

	@RequestMapping(value = "/getData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resources<Manufacturer> getData() {
		ServiceInstance serviceInstance = loadBalClient.choose("manufacturer-microservice");
		RestTemplate restTemplate = new RestTemplate();
		TypeToken<Resources<Manufacturer>> stringListTok = new TypeToken<Resources<Manufacturer>>() {};
		Resources<Manufacturer> resources = null;
		try {
			resources = (Resources<Manufacturer>) restTemplate.getForObject(new URI(serviceInstance.getUri().toString().concat("/rep")), Object.class);
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}
		return resources;  
	}
}