package com.example.apiproject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiproject.entity.Venue;

import com.example.apiproject.service.VenueService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/venue")
public class VenueController {
    
    @Autowired
    VenueService venueservice;

    @GetMapping
    public List<Venue> getAllVenue()
    {
        return venueservice.getAllVenues();
    }
    
    @PutMapping("/{id}")
    public Venue updateVenue(@PathVariable Long id,@RequestBody Venue venuedetails)
    {
        return venueservice.updateVenue(id,venuedetails);
        
    }

    @PostMapping
    public Venue createVenue(@RequestBody Venue venue)
    {
        return venueservice.createVenue(venue);
    }

    
    @DeleteMapping("/{id}")
    public void deleteVenue(@PathVariable Long id)
    {
        venueservice.deleteVenue(id);
    }

    @GetMapping("/paging")
    public org.springframework.data.domain.Page<Venue> getVenue(@RequestParam (defaultValue="1")int page,@RequestParam (defaultValue="3")int size) {
        return venueservice.getPageVenue(page, size);
    }

    @GetMapping("/get/sort/{name}")
    public List<Venue> getSorted (@PathVariable String name) {
        return venueservice.getSorted(name);
    }
  
}