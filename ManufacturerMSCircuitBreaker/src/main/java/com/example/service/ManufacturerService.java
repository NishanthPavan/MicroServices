package com.example.service;

import org.springframework.hateoas.Resources;

import com.example.model.Manufacturer;

public interface ManufacturerService {

	Resources<Manufacturer> findAll();
}
