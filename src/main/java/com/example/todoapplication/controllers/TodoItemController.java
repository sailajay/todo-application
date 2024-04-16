package com.example.todoapplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoItemController {
	private final Logger logger = LoggerFactory.getLogger(TodoItemController.class);
	
	@GetMapping("/")
	public ModelAndView Index() {
		logger.info("request for index");
		
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
}
