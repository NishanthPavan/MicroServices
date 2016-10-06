package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.model.Manufacturer;

@RepositoryRestResource(path = "/rep")
public interface ManufacturerRepository extends MongoRepository<Manufacturer, Integer> {

	//@Query(value="{'startDate':?0}", fields="{'startDate':0}")
	List<Manufacturer> findByStartDateBefore(Date date);
}