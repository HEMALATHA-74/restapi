package com.example.apiproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.apiproject.entity.Event;
import com.example.apiproject.repository.EventRepository;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Create a new user
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Get all users
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    // public Optional<Event> getEventById(Long id) {
    //     return eventRepository.findById(id);
    // }
    public Event updateEvent(Long id,Event eventdetails)
    {
        eventdetails.setId(id);
        return eventRepository.save(eventdetails);
        
    }


    // Delete user by ID
    public String deleteEvent(Long id) {
        eventRepository.deleteById(id);
        return "Sucess";
    }

    public Page<Event> getPageEvent(@RequestParam int page,@RequestParam int size){
        PageRequest pageable=PageRequest.of(page,size);
        return eventRepository.findAll(pageable);
    }

    
     public List<Event> getSorted(String eventName)
   {
    return eventRepository.findAll(Sort.by(Sort.Direction.ASC,eventName));
   }

   
}



