package tech.costanzo.sabpix.web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix="controller.sample")
@Data
public class SampleControllerProperties {
	private String message;
}
