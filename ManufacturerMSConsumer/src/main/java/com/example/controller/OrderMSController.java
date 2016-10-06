package com.example.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.model.Manufacturer;

@RestController
public class OrderMSController {

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/manPost", method = RequestMethod.GET)
	public ResponseEntity<String> getDate() {
		RestTemplate template = new RestTemplate();
		List<ServiceInstance> list = client.getInstances("manufacturer-microservice");
		if (!list.isEmpty()) {
			URI uri = list.get(0).getUri();
			if (null != uri) {
				Manufacturer manufacturer1 = new Manufacturer(20, new Date(), "MAN1");
				//Manufacturer manufacturer2 = new Manufacturer(21, new Date(), "MAN2");

				/*List<Manufacturer> manList = new ArrayList<Manufacturer>();
				manList.add(manufacturer1);
				manList.add(manufacturer2);*/

				try {
					return template.postForEntity(new URI(uri.toString().concat("/rep")), manufacturer1, String.class);
				} catch (RestClientException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
