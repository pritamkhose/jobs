package com.pritam.jobs.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class IndexController {

	@Operation(summary = "Home")
    @RequestMapping(value="/", method = RequestMethod.GET)
    public Object getData(){
    	HashMap<String, Object> hm = new HashMap<String, Object>();
    	hm.put("Message", "Server is Running");
    	hm.put("Date", new Date());
        return hm;
    }
    
}
