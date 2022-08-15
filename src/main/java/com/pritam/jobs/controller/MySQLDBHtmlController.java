package com.pritam.jobs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.pritam.jobs.model.Data;
import com.pritam.jobs.service.DataService;

@Controller
@RequestMapping("/data/dataHTML")
public class MySQLDBHtmlController {

	@Autowired
	private DataService dataService;

	@GetMapping("")
	public ModelAndView listDataHTML(Model model) {
		List<Data> datas = dataService.findAll();
		model.addAttribute("datas", datas);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("data/data.table.html");
		return modelAndView;
	}

	@GetMapping(value = { "/edit/{id}", "/edit" })
	public ModelAndView editDataHTML(Model model, @PathVariable(value = "id") Long id) {
		if (id == 0) {
			Data d = new Data();
			d.setId(0);
			d.setTitle("");
			d.setDescp("");
			d.setPhone(0);
			d.setPin(0);
			model.addAttribute("data", d);
		} else {
			model.addAttribute("data", dataService.find(id));
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/data/edit.html");
		return modelAndView;
	}

	@GetMapping("/delete/{id}")
	public String deleteDataHTML(Model model, @PathVariable(value = "id") Long id) {
		if (dataService.existsById(id)) {
			dataService.delete(id);
		}
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("/data/data.table.html");
//		return modelAndView;
		return "redirect:/data/dataHTML";
	}

	@PostMapping("/submitData")
	public String submitData(@Valid Data data, BindingResult result, Model model) {
		String nav = "/dataHTML/edit/"+ data.getId();
		if (result.hasErrors()) {
			return nav;
		}
		try {
			dataService.save(data);
			return "redirect:/data/dataHTML";
		} catch(Exception e) {
			return nav;
		}
	}

}
