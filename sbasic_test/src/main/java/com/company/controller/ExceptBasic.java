package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ExceptBasic {
	
	@RequestMapping(value="/basic", method = RequestMethod.GET)
	public String test(@RequestParam("data") int data, Model model) {
		model.addAttribute("data", data);
		return "basic";
	}
}
