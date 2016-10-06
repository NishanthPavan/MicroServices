package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class CustomLoadBalancerAlgo {

	@Autowired
	private IClientConfig ribbonClientConfig;

	@Bean
	@Autowired
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl();
	}

	@Bean
	@Autowired
	public IRule ribbonAvailablity(IClientConfig config) {
		return new AvailabilityFilteringRule();
	}

}
