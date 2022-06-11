package com.pritam.jobs.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pritam.jobs.model.Address;
import com.pritam.jobs.model.MasterAddr;
import com.pritam.jobs.service.MasterAddrService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/config")
public class MasterDataController {

	@Autowired
	private MasterAddrService masterAddrService;

	@SuppressWarnings("unchecked")
	@Operation(summary = "Master data config")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Object> getConfig(@RequestParam(required = false) String type) {
		String fileName = "config";
		if (type != null && type.length() > 0) {
			fileName = type.toLowerCase();
		}
		try {
			File file = ResourceUtils.getFile("classpath:json/" + fileName + ".json");
			String content = new String(Files.readAllBytes(file.toPath()));
			Gson gson = new Gson();
			HashMap<String, Object> json = (gson).fromJson(content, HashMap.class);
			return new ResponseEntity<Object>(json, HttpStatus.OK);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "addr", method = RequestMethod.GET)
	public ResponseEntity<List<MasterAddr>> getAddr(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "25") Integer pageSize, @RequestParam(defaultValue = "ID") String sortBy) {
		List<MasterAddr> result = masterAddrService.getAddr(pageNo, pageSize, sortBy);
		return new ResponseEntity<List<MasterAddr>>(result, result.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}

	@RequestMapping(value = "pincode", method = RequestMethod.GET)
	public ResponseEntity<List<MasterAddr>> getPincode(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "25") Integer pageSize, @RequestParam(defaultValue = "0") Integer pincode) {
		List<MasterAddr> result = masterAddrService.getPincode(pageNo, pageSize, pincode);
		return new ResponseEntity<List<MasterAddr>>(result, result.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}

}
