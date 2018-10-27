package ch.agilesolutions.boot.start.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.agilesolutions.boot.start.logging.LoggerInjector;

@Configuration
@ConditionalOnClass(LoggerInjector.class)
@EnableConfigurationProperties(LoggingPoperties.class)
public class LoggingAutoConfiguration {
	
    @Autowired
    private LoggingPoperties loggingProperties;

	@Bean
	@ConditionalOnMissingBean
	public LoggerUtils loggerUtils() {
		return new LoggerUtils(loggingProperties);
	}
	
    @Bean
    @ConditionalOnMissingBean
    public LoggingConfig logginConfig() {
 
 
    	LoggingConfig loggingConfig = new LoggingConfig();
    	
    	loggingProperties.getLoggers().forEach(entry -> {loggingConfig.put(entry.getName(), entry.getPattern());});
    	

        return loggingConfig;
    }
	
    @Bean
    @ConditionalOnMissingBean
    public LoggerInjector instantiateLoggerInjector() {
        return new LoggerInjector();
    }

}
