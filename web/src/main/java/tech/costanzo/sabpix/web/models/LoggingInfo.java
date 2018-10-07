package tech.costanzo.sabpix.web.models;

import lombok.Data;

@Data
public class LoggingInfo {
	private String message;
	private String severity;
	private String suppression;
}
