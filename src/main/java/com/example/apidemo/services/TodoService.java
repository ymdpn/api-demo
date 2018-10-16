package com.example.apidemo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apidemo.dto.TodoDto;
import com.example.apidemo.models.Todo;
import com.example.apidemo.repositories.TodoRepository;

@Service
@Transactional
public class TodoService {
	
	@Autowired
	TodoRepository repository;
	
	/**
	 * 全てのTodoDTOリストを返却する。
	 * 
	 * @return TodoDtoリスト 全データ
	 */
	public List<TodoDto> findAll() {
		var list = repository.findAll();
		return list.stream().map(entity -> entityToDto(entity)).collect(Collectors.toList());
	}
	
	/**
	 * authorとタイトルに紐付くTodoDTOリストを返却する。
	 * 
	 * @param author 完全一致
	 * @param title 部分一致
	 * @return TodoDtoリスト
	 */
	public List<TodoDto> findByAuthorAndTitle(Long author, String title) {
		var list = repository.findByAuthorAndTitleContaining(author, title);
		return list.stream().map(entity -> entityToDto(entity)).collect(Collectors.toList());
	}
	
	/**
	 * authorと本文に紐付くTodoDTOリストを返却する。
	 * 
	 * @param author 完全一致
	 * @param textValue 部分一致
	 * @return TodoDtoリスト
	 */
	public List<TodoDto> findByAuthorAndTextValue(Long author, String textValue) {
		var list = repository.findByAuthorAndTextValueContaining(author, textValue);
		return list.stream().map(entity -> entityToDto(entity)).collect(Collectors.toList());
	}
	
	/**
	 * ToDoテーブルにデータを永続化する。
	 * 
	 * @param dto
	 * @return　保存済みデータ
	 */
	public TodoDto save(TodoDto dto) {
		var entity = dtoToEntity(dto);
		return entityToDto(repository.save(entity));
	}
	
	/**
	 * キーに合致するレコードを削除する。
	 * 
	 * @param todosKey
	 */
	public void delete(Long todosKey) {
		repository.deleteById(todosKey);
	}
	
	private TodoDto entityToDto(Todo entity) {
		TodoDto dto = new TodoDto();
		dto.setAuthor(entity.getAuthor());
		dto.setTextValue(entity.getTextValue());
		dto.setTitle(entity.getTitle());
		dto.setTodosKey(entity.getTodosKey());
		return dto;
	}
	
	private Todo dtoToEntity(TodoDto dto) {
		Todo entity = new Todo();
		entity.setAuthor(dto.getAuthor());
		entity.setTextValue(dto.getTextValue());
		entity.setTitle(dto.getTitle());
		entity.setTodosKey(dto.getTodosKey());
		return entity;
	}
}
