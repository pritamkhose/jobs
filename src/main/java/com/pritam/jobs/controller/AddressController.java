package com.pritam.jobs.controller;

import java.util.List;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.pritam.jobs.model.Address;
import com.pritam.jobs.service.AddressService;

@RestController
@RequestMapping("/address")
//@Api(description = "MySQL Database CRUD operation")
public class AddressController {
	
	@Autowired
	private AddressService addressService;

//	@ApiOperation(value = "View a list")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Address> listData() {
		return addressService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getData(@PathVariable(value = "id") Long id) {
		if (addressService.existsById(id)) {
			return new ResponseEntity<Object>(addressService.find(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Address> create(@RequestBody Address address) {
		System.out.println(">>"+  (new Gson()).toJson(address));
//		return new ResponseEntity<Address>(address, HttpStatus.OK);
		if (addressService.existsById(address.getId())) {
			return new ResponseEntity<Address>(addressService.save(address), HttpStatus.OK);
		} else {
			return new ResponseEntity<Address>(addressService.save(address), HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
		if (addressService.existsById(id)) {
			addressService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
}
