package com.pritam.jobs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pritam.jobs.service.FilesStorageService;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class JobsApplication implements CommandLineRunner {

	private static final Logger LOGGER = LogManager.getLogger(JobsApplication.class);

	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {

		LOGGER.info("Sample Info level log message");
		LOGGER.debug("Sample Debug level log message");
		LOGGER.error("Sample Error level log message");
		LOGGER.info("Server started here -->> " + (new Date()));
		LOGGER.info("System env -->> " + (System.getenv()));

		SpringApplication.run(JobsApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}
}
