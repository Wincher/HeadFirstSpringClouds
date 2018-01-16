package io.wincher.cloud.consumer.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class HelloController {
	
	protected Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	private final String APP_NAME = "SERVICE-HELLO";
	
	@Autowired
	@Qualifier(value = "restTemplate")
	private RestTemplate restTemplate;
	
	@Autowired
	@Qualifier(value = "lbcRestTemplate")
	private RestTemplate lbcRestTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return restTemplate.getForEntity("http://" + APP_NAME + "/hello", String.class).getBody();
	}
	
	@RequestMapping(value = "/helloEx", method = RequestMethod.GET)
	public String helloEx() {
		ServiceInstance instance = this.loadBalancerClient.choose(APP_NAME);
		URI helloUri = URI.create(String.format("http://%s:%s/hello", instance.getHost(), instance.getPort()));
		logger.info("Target service url = {}", helloUri.toString());
		return this.lbcRestTemplate.getForEntity(helloUri, String.class).getBody();
	}
	
}
