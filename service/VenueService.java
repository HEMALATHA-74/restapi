package com.example.apiproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.apiproject.entity.Venue;
import com.example.apiproject.repository.VenueRepository;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    // Create a new Venue
    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    // Get all venues
    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    

    // Update a venue by its ID
    
    public void deleteVenue(Long id) {
        venueRepository.deleteById(id);
    }

    public Page<Venue> getPageVenue(@RequestParam int page,@RequestParam int size){
        PageRequest pageable=PageRequest.of(page,size);
        return venueRepository.findAll(pageable);
    }



     public List<Venue> getSorted(String name)
   {
    return venueRepository.findAll(Sort.by(Sort.Direction.ASC,name));
   }
    
   public Venue updateVenue(Long id,Venue venuedetails)
    {
        venuedetails.setId(id);
        return venueRepository.save(venuedetails);
        
    }

}

