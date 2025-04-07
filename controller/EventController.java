package com.example.apiproject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiproject.entity.Event;
import com.example.apiproject.service.EventService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/events")
public class EventController {
    
    @Autowired
    EventService eventservice;

    @GetMapping
    public List<Event> getAllUsers()
    {
        return eventservice.getAllEvents();
    }
    

    @PostMapping
    public Event createEvent(@RequestBody Event event)
    {
        return eventservice.createEvent(event);
    }
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id,@RequestBody Event eventdetails)
    {
        return eventservice.updateEvent(id,eventdetails);
        
    }
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id)
    {
        eventservice.deleteEvent(id);
        return "succes";
    }

    @GetMapping("/paging")
    public org.springframework.data.domain.Page<Event> getEvent(@RequestParam (defaultValue="1")int page,@RequestParam (defaultValue="3")int size) {
        return eventservice.getPageEvent(page, size);
    }

    @GetMapping("/get/sort/{eventName}")
    public List<Event> getSorted (@PathVariable String eventName) {
        return eventservice.getSorted(eventName);
    }
    
    

}