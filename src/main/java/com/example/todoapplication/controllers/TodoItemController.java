package com.example.todoapplication.controllers;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.todoapplication.models.TodoItem;
import com.example.todoapplication.repositories.TodoItemRepository;

import jakarta.validation.Valid;

@Controller
public class TodoItemController {
	private final Logger logger = LoggerFactory.getLogger(TodoItemController.class);
	
	@Autowired
	private TodoItemRepository todoItemRepository;
	
	@GetMapping("/")
	public ModelAndView Index() {
		logger.info("request for index");
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		modelAndView.addObject("todoItems", todoItemRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping("/todo/{id}")
	public String updateToDoItem(@PathVariable("id") long id, @Valid TodoItem todoItem, BindingResult result, Model model) {
		
		if (result.hasErrors()){
			todoItem.setId(id);
			return "update-todo-item";
		}
		todoItem.setModifiedDate(Instant.now());
		todoItemRepository.save(todoItem);
		return "redirect:/";
	}
	
}
