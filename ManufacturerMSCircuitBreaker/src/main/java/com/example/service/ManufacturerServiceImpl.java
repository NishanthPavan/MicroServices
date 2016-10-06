package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import com.example.dao.ManufacturerMSFeignClient;
import com.example.model.Manufacturer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	private ManufacturerMSFeignClient dao;

	@Override
	@HystrixCommand(fallbackMethod = "findAllFallback")
	public Resources<Manufacturer> findAll() {
		return dao.findAll();
	}

	public Resources<Manufacturer> findAllFallback() {
		Link links = new Link("http://TEST");
		List<Manufacturer> content = new ArrayList<Manufacturer>();
		content.add(new Manufacturer(100, new Date(), "FALLBACK1"));
		content.add(new Manufacturer(101, new Date(), "FALLBACK2"));
		content.add(new Manufacturer(102, new Date(), "FALLBACK3"));
		Resources<Manufacturer> resources = new Resources<Manufacturer>(content, links);
		return resources;
	}
}