package com.shahkaar.asynchronouslywebclient.service;

import com.shahkaar.asynchronouslywebclient.json.AstroResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AstroService {

	private final WebClient client;

	AstroService() {
		this.client = WebClient.create("http://api.open-notify.org");
	}
	
	public Mono<AstroResponse> getPeopleInSpaceData() {
		return client.get()
				.uri("/astros.json")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(AstroResponse.class)
				.log();
	}
}
