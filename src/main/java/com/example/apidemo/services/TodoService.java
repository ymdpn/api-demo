package com.example.apidemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apidemo.models.Todo;
import com.example.apidemo.repositories.TodoRepository;

@Service
@Transactional
public class TodoService {
	
	@Autowired
	TodoRepository repository;
	/**
	 * 全てのTODOリストを返す。
	 * @return List<Todo> 全データ
	 */
	public List<Todo> findAll() {
		return repository.findAll();
	}
}
