package com.example.apiproject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiproject.entity.User;
import com.example.apiproject.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userservice;

    @GetMapping
    public List<User> getAllUsers()
    {
        return userservice.getAllUsers();
    }
    

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return userservice.createUser(user);
    }

    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        userservice.deleteUser(id);
        return "succes";
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User userdetails)
    {
        return userservice.updateUser(id,userdetails);
        
    }

    @GetMapping("/paging")
    public org.springframework.data.domain.Page<User> getUsers(@RequestParam (defaultValue="1")int page,@RequestParam (defaultValue="3")int size) {
        return userservice.getPageUsers(page, size);
    }

    @GetMapping("/get/sort/{name}")
    public List<User> getSorted (@PathVariable String name) {
        return userservice.getsorted(name);
    }
    //JPQL Methods
    @GetMapping("/get/find-by/{name}")
    public List<User> findByUserName(@PathVariable String name)
    {
        return userservice.findByUserName(name);
    }
}