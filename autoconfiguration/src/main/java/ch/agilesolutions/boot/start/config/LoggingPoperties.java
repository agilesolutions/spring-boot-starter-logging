package ch.agilesolutions.boot.start.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import ch.agilesolutions.boot.start.model.Logger;

@ConfigurationProperties(prefix = "spring.logging")
public class LoggingPoperties {
	
	private List<Logger> loggers;


	public List<Logger> getLoggers() {
		return loggers;
	}

	public void setLoggers(List<Logger> loggers) {
		this.loggers = loggers;
	}
	
	
	

}