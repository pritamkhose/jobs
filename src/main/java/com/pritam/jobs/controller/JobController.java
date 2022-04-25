package com.pritam.jobs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pritam.jobs.model.Address;
import com.pritam.jobs.model.Education;
import com.pritam.jobs.model.Job;
import com.pritam.jobs.model.Users;

import com.pritam.jobs.service.UserService;
import com.pritam.jobs.service.AddressService;
import com.pritam.jobs.service.EducationService;

@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private EducationService educationService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Job> getData(@PathVariable(value = "id") Long id) {
		Users user = userService.find(id);
		List<Address> address = addressService.findRefID(id);
		List<Education> education = educationService.findRefID(id);
		if (user != null) {
			return new ResponseEntity<Job>(new Job(id, user, address, education), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Job> create(@PathVariable(value = "id") Long id, @Valid @RequestBody Job job) {
		Users user = userService.find(id);
		List<Address> address = job.getAddress();
		List<Education> education = job.getEducation();
		if (user != null) {
			if (address.size() == 0 && education.size() == 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else {
				if (address.size() > 0) {
					address = addressService.saveList(address, id);
				}
				if (education.size() > 0) {
					education = educationService.saveList(education, id);
				}
				return new ResponseEntity<Job>(new Job(id, user, address, education), HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
		Users user = userService.find(id);
		if (user != null) {
			userService.delete(id);
			addressService.deleteByRefID(id);
			educationService.deleteByRefID(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
