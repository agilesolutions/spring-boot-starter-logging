# A Spring Boot Starter for custom Logback loggers and appenders integration

This is a Spring Boot starter for automatically configuring Logback loggers and appenders on your spring Boot application. This will let developers configure Logback loggers and appenders through the standard Spring boot application.yml configuration file.


# Dependency

```xml
<dependency>
  <groupId>ch.agilesolutions.boot</groupId>
  <artifactId>logging-spring-boot-starter</artifactId>
  <version>0.0.1</version>
</dependency>
```


### Example how to configure Logback loggers and appenders:

```
spring:
  logging:
	loggers:
	  -
	    name: SecurityLogger
	    level: ...
	    additive: ...
	    file: ...
	  -
	    name: AuditLogger
	    level: ...
	    additive: ...
	    file: ...
```
