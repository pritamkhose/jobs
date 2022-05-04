package com.pritam.jobs.controller;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class IntergrationController {
	
	String baseURL = "http://localhost:8080/";
	RestTemplate restTemplate = new RestTemplate();

	@Operation(summary = "Swagger Intergration")
	@RequestMapping(value = "/swagger", method = RequestMethod.GET)
	public Object getData() {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("Name", "Jobs App");
		hm.put("Status", "Server is Running");
		hm.put("health", getHealth());
		hm.put("models", getModels());
		return hm;
	}

	@SuppressWarnings("unchecked")
	private Object getHealth() {
		try {
			HashMap<String, Object> json = new HashMap<String, Object>();
			ResponseEntity<String>  response = restTemplate.getForEntity(baseURL + "actuator/health", String.class);
			json = (new Gson()).fromJson(response.getBody(), HashMap.class);
			return json;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private Object getModels() {
		try {
			HashMap<String, Object> json = new HashMap<String, Object>();
			ResponseEntity<HashMap>  response = restTemplate.getForEntity(baseURL + "api-docs", HashMap.class);
			json = (HashMap<String, Object>) response.getBody().get("components");
			return json.get("schemas");
		} catch (Exception e) {
			return null;
		}
	}

}
