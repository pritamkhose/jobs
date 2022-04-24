package com.pritam.jobs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pritam.jobs.model.Users;
import com.pritam.jobs.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Users> create(@Valid @RequestBody Users user) {
		if (userService.existsByUser(user)) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Users>(userService.save(user), HttpStatus.CREATED);
		}

	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Users> listData() {
		return userService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getData(@PathVariable(value = "id") Long id) {
		if (userService.existsById(id)) {
			return new ResponseEntity<Object>(userService.find(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
		if (userService.existsById(id)) {
			userService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
