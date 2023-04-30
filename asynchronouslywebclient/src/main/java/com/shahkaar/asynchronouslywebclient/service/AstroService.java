package com.shahkaar.asynchronouslywebclient.service;

import com.shahkaar.asynchronouslywebclient.json.AstroResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AstroService {

	private final RestTemplate restTemplate;
	
	AstroService(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	public String getPeopleInSpace() {
		return restTemplate.getForObject("http://api.open-notify.org/astros.json", String.class);
	}

	public AstroResponse getPeopleInSpaceData() {
		return restTemplate.getForObject("http://api.open-notify.org/astros.json", AstroResponse.class);
	}
}
