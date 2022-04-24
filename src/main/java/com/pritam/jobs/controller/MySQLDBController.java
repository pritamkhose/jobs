package com.pritam.jobs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.pritam.jobs.model.Data;
import com.pritam.jobs.service.DataService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/data")
public class MySQLDBController {

	@Autowired
	private DataService dataService;

	@Operation(summary = "View a Data list")
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public List<Data> listData() {
		return dataService.findAll();
	}

	@GetMapping("/dataHTML")
	public ModelAndView listDataHTML(Model model) {
		List<Data> datas = dataService.findAll();
		model.addAttribute("datas", datas);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("data/data.table.html");
		return modelAndView;
	}

	@RequestMapping(value = "/data/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getData(@PathVariable(value = "id") Long id) {
		if (dataService.existsById(id)) {
			return new ResponseEntity<Object>(dataService.find(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public ResponseEntity<Data> create(@RequestBody Data data) {
		if (dataService.existsById(data.getId())) {
			return new ResponseEntity<Data>(dataService.save(data), HttpStatus.OK);
		} else {
			return new ResponseEntity<Data>(dataService.save(data), HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/data/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
		if (dataService.existsById(id)) {
			dataService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
