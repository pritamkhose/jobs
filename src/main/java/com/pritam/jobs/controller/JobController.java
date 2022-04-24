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

//	@RequestMapping(value = "", method = RequestMethod.POST)
//	public ResponseEntity<Job> create(@Valid @RequestBody Job job) {
//		if (jobService.existsById(job.getId())) {
//			return new ResponseEntity<Job>(jobService.save(job), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
//		if (jobService.existsById(id)) {
//			jobService.delete(id);
//			return new ResponseEntity<Void>(HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}

}
