package com.example.todoapplication.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.todoapplication.models.TodoItem;
import com.example.todoapplication.repositories.TodoItemRepository;

@Component
public class TodoItemDataLoader implements CommandLineRunner {
	private final Logger logger =LoggerFactory.getLogger(TodoItemDataLoader.class);
	
	@Autowired
	TodoItemRepository todoItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		loadSeedData();
	}
	
	private void loadSeedData() {
		if (todoItemRepository.count() ==0) {
			TodoItem todoItem1 = new TodoItem("get milk");
			TodoItem todoItem2 = new TodoItem("get bread");
			
			todoItemRepository.save(todoItem1);
			todoItemRepository.save(todoItem2);
			
		}
		logger.info("Number of todoitems: {}", todoItemRepository.count() );
	}
	
}
