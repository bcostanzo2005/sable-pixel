package tech.costanzo.sabpix.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import tech.costanzo.sabpix.web.properties.SampleControllerProperties;

@RestController
public class SampleController {
	
	private SampleControllerProperties properties;
	
	public SampleController(SampleControllerProperties properties) {
		this.properties = properties;
	}
	
	@GetMapping("/hello")
	public Mono<String> hello() {
		return Mono.just(properties.getMessage());
	}
}
