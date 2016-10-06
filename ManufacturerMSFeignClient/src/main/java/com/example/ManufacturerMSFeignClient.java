package com.example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Manufacturer;

@FeignClient("manufacturer-microservice")
public interface ManufacturerMSFeignClient {

	@RequestMapping(value = "/rep", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Resources<Manufacturer> findAll();

	@RequestMapping(value = "/rep/search/findByStartDateBefore", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Resources<Manufacturer> findByStartDateBefore(@RequestParam("date") String date);
	
	//@RequestMapping(value = "/rep/search/findByStartDateBeforeTEMP/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	//List<Manufacturer> findByStartDateBeforeTEMP(@PathVariable("date") @DateTimeFormat(iso = ISO.DATE) Date date);
	
}
