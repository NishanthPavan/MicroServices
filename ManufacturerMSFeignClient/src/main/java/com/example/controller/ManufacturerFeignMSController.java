package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ManufacturerMSFeignClient;
import com.example.model.Manufacturer;

@RestController
public class ManufacturerFeignMSController {

	@Autowired
	private ManufacturerMSFeignClient feignClient;

	@RequestMapping(value = "/getData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resources<Manufacturer> getData() {
		Resources<Manufacturer> manList = feignClient.findAll();
		return manList;  
	}
}