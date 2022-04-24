package com.pritam.jobs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pritam.jobs.model.Address;
import com.pritam.jobs.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Address> listData() {
		return addressService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Address> getData(@PathVariable(value = "id") Long id) {
		if (addressService.existsById(id)) {
			return new ResponseEntity<Address>(addressService.find(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Address> create(@Valid @RequestBody Address address) {
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
