package com.pritam.jobs.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/config")
public class MasterDataController {

	@SuppressWarnings("unchecked")
	@Operation(summary = "Master data config")
    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<Object> getConfig(@RequestParam(required = false) String type){
		String fileName = "config";
		if(type != null && type.length() > 0) {
			fileName = type.toLowerCase();
		}
		try {
			File file = ResourceUtils.getFile("classpath:json/"+fileName+".json");
			String content = new String(Files.readAllBytes(file.toPath()));
			Gson gson = new Gson();
		    HashMap<String, Object> json = (gson).fromJson(content, HashMap.class);
		    return new ResponseEntity<Object>(json, HttpStatus.OK);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}  catch (IOException e) {
	        e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
    }
    
}
