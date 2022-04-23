package com.pritam.jobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class JobsApplication {
	

	private static final Logger LOGGER = LogManager.getLogger(JobsApplication.class);
	
	public static void main(String[] args) {
		
		LOGGER.info("Sample Info level log message");
		LOGGER.debug("Sample Debug level log message");
		LOGGER.error("Sample Error level log message");
		LOGGER.info("Server started here -->> " + (new Date()));
		LOGGER.info("System env -->> " +(System.getenv()));
		
		
		SpringApplication.run(JobsApplication.class, args);
	}
}
