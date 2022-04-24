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

import com.pritam.jobs.model.Education;
import com.pritam.jobs.service.EducationService;

@RestController
@RequestMapping("/education")
public class EducationController {

	@Autowired
	private EducationService educationService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Education> listData() {
		return educationService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Education> getData(@PathVariable(value = "id") Long id) {
		if (educationService.existsById(id)) {
			return new ResponseEntity<Education>(educationService.find(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Education> create(@Valid @RequestBody Education education) {
		if (educationService.existsById(education.getId())) {
			return new ResponseEntity<Education>(educationService.save(education), HttpStatus.OK);
		} else {
			return new ResponseEntity<Education>(educationService.save(education), HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
		if (educationService.existsById(id)) {
			educationService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
