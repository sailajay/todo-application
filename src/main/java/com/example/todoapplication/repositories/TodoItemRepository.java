package com.example.todoapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.todoapplication.models.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long>{

	
}
