package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Manufacturer;
import com.example.repository.ManufacturerRepository;

@RestController
public class ManufacturerController {

	@Autowired
	private ManufacturerRepository repository;

	@RequestMapping(value = "/findByStartDate/{startDate}", method = RequestMethod.GET)
	public List<Manufacturer> findByStartDate(@DateTimeFormat(iso = ISO.DATE) @PathVariable("startDate") Date date) {
		System.out.println(date);
		return repository.findByStartDateBefore(date);
	}
}
