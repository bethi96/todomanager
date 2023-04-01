package com.example.tharun.todomanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tharun.todomanager.entity.Todomanager;
import com.example.tharun.todomanager.repository.TodomanagerRepository;
import com.example.tharun.todomanager.service.TodomanagerService;

@Service
public class TodomanagerServiceImpl implements TodomanagerService {
	
	
	private TodomanagerRepository todomanagerRepository;
	
	
	public TodomanagerServiceImpl(TodomanagerRepository todomanagerRepository) {
		super();
		this.todomanagerRepository = todomanagerRepository;
	}


	@Override
	public List<Todomanager> getAllTodos() {
		return todomanagerRepository.findAll();
	}


	@Override
	public Todomanager saveTodo(Todomanager todomanager) {
		// TODO Auto-generated method stub
		return todomanagerRepository.save(todomanager);
	}


	@Override
	public Todomanager updateTodo(Todomanager todomanager) {
		// TODO Auto-generated method stub
		return todomanagerRepository.save(todomanager);
	}


	@Override
	public Todomanager getTodoById(Long id) {
		// TODO Auto-generated method stub
		return todomanagerRepository.findById(id).get();
	}


	@Override
	public void deleteTodoById(Long id) {
		// TODO Auto-generated method stub
		todomanagerRepository.deleteById(id);
	}

}
