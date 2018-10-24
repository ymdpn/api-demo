package com.example.apidemo.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apidemo.dto.TodoDto;
import com.example.apidemo.services.TodoService;

@RestController
@CrossOrigin
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	TodoService service;

    @RequestMapping(value = "/", method = GET)
	public List<TodoDto> index() {
		return service.findAll();
	}
    
    @RequestMapping(value = "/create", method = POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public TodoDto create(@RequestBody @Validated TodoDto dto) {
    	return service.save(dto);
    }
    
    @RequestMapping(value = "/update/todosKey={todosKey}", method = POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public TodoDto update(@RequestBody @Validated TodoDto dto, @PathVariable("todosKey") Long todosKey) {
    	dto.setTodosKey(todosKey);
    	return service.save(dto);
    }
    
    @RequestMapping(value = "/find/author={author}/title={title}", method = GET)
    public List<TodoDto> findByTitle(@PathVariable("author") Long author, @PathVariable("title") String title) {
    	return service.findByAuthorAndTitle(author, title);
    }
    
    @RequestMapping(value = "/find/author={author}/textValue={textValue}", method = GET)
    public List<TodoDto> findByTextValue(@PathVariable("author") Long author, @PathVariable("textValue") String textValue) {
    	return service.findByAuthorAndTextValue(author, textValue);
    }
    
    @RequestMapping(value="/delete/todosKey={todosKey}", method = DELETE)
    public void delete(@PathVariable("todosKey") Long todosKey) {
    	service.delete(todosKey);
    }
}
