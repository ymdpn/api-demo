package com.example.apidemo.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apidemo.models.Todo;
import com.example.apidemo.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	TodoService service;

    @RequestMapping(value = "/all", method = GET)
    @CrossOrigin
	public ResponseEntity<List<Todo>> index() {
		return ResponseEntity.ok(service.findAll());
	}
}
