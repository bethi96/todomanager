package com.example.tharun.todomanager.service;

import java.util.List;


import com.example.tharun.todomanager.entity.Todomanager;


public interface TodomanagerService {
	
	List<Todomanager> getAllTodos();
	
	Todomanager saveTodo(Todomanager todomanager);
	
	Todomanager updateTodo(Todomanager todomanager);
	
	Todomanager getTodoById(Long id);
	
	void deleteTodoById(Long id);
}
