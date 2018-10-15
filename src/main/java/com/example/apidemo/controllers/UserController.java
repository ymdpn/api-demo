package com.example.apidemo.controllers;

import com.example.apidemo.services.UserService;
import com.example.apidemo.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping(value = "/all", method = GET)
    public List<User> index() {
        return service.findAll();
    }
}