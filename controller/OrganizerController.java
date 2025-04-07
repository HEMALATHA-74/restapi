package com.example.apiproject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiproject.entity.Organizer;
import com.example.apiproject.service.OrganizerService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/organizers")
public class OrganizerController {
    
    @Autowired
    OrganizerService organizerService;

    @GetMapping
    public List<Organizer> getAllOrganizer()
    {
        return organizerService.getAllOrganizer();
    }

    @PutMapping("/{id}")
    public Organizer updateOrganizer(@PathVariable Long id,@RequestBody Organizer organizerdetails)
    {
        return organizerService.updateOrganizer(id,organizerdetails);
        
    }

    @PostMapping
    public Organizer createOrganizer(@RequestBody Organizer organizer)
    {
        return organizerService.createOrganizer(organizer);
    }

    
    @DeleteMapping("/{id}")
    public void deleteOrganizer(@PathVariable Long id)
    {
        organizerService.deleteOrganizer(id);
    }

    @GetMapping("/paging")
    public org.springframework.data.domain.Page<Organizer> getOrganizer(@RequestParam (defaultValue="1")int page,@RequestParam (defaultValue="3")int size) {
        return organizerService.getPageOrganizer(page, size);
    }
     @GetMapping("/get/sort/{name}")
    public List<Organizer> getSorted (@PathVariable String name) {
        return organizerService.getSorted(name);
    }
    
   
}