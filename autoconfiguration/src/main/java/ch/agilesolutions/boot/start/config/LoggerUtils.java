package ch.agilesolutions.boot.start.config;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;

public class LoggerUtils {

	public LoggerUtils(LoggingPoperties loggingProperties) {

		for (ch.agilesolutions.boot.start.model.Logger logger : loggingProperties.getLoggers()) {

			createLoggerFor(logger.getName(), logger.getFile(), logger.getAdditive());

		}

	}

	private void createLoggerFor(String string, String file, String additive) {
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		PatternLayoutEncoder ple = new PatternLayoutEncoder();

		ple.setPattern("%date %level [%thread] %logger{10} [%file:%line] %msg%n");
		ple.setContext(lc);
		ple.start();
		FileAppender<ILoggingEvent> fileAppender = new FileAppender<ILoggingEvent>();
		fileAppender.setFile(file);
		fileAppender.setEncoder(ple);
		fileAppender.setContext(lc);
		fileAppender.start();

		Logger logger = (Logger) LoggerFactory.getLogger(string);
		logger.addAppender(fileAppender);
		logger.setLevel(Level.DEBUG);
		logger.setAdditive(false); /* set to true if root should log too */

	}

}