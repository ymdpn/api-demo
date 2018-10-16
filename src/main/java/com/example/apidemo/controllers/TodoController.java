package com.example.apidemo.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

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
    
    @RequestMapping(value="/create", method = POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public TodoDto create(@RequestBody @Validated TodoDto dto) {
    	return service.save(dto);
    }
    
    @RequestMapping(value="/update?todosKey= {todosKey}", method = POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public TodoDto update(@RequestBody @Validated TodoDto dto, @PathVariable Long todosKey) {
    	dto.setTodosKey(todosKey);
    	return service.save(dto);
    }
    
    @RequestMapping(value="/delete?todosKey= {todosKey}", method = DELETE)
    public void delete(@PathVariable Long todosKey) {
    	service.delete(todosKey);
    }
}
