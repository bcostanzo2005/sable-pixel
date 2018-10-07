package tech.costanzo.sabpix.web.controllers;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.costanzo.sabpix.web.models.LoggingInfo;

@RestController
@RequestMapping("config")
public class ConfigController {
	
	private Environment environment;
	
	public ConfigController(Environment environment) {
		this.environment = environment;
	}
	
	@GetMapping("/get/{key}")
	public Flux<String> getProp(@PathVariable("key") String key) {
		return Flux.just(String.valueOf(environment.getProperty(key)));
	}
	
	@GetMapping("/getloginfo/{key}")
	public Mono<LoggingInfo> getLoggingInfo(@PathVariable("key") String key) {
		LoggingInfo info = new LoggingInfo();
		info.setMessage(environment.getProperty(key + ".message"));
		info.setSeverity(environment.getProperty(key + ".severity"));
		info.setSuppression(environment.getProperty(key + ".suppression"));
		return Mono.just(info);
	}
}
