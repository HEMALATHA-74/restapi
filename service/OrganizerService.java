package com.example.apiproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.apiproject.entity.Organizer;
import com.example.apiproject.repository.OrganizerRepository;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public List<Organizer> getAllOrganizer() {
        return organizerRepository.findAll();
    }

    // Delete user by ID
    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }
    public Page<Organizer> getPageOrganizer(@RequestParam int page,@RequestParam int size){
        PageRequest pageable=PageRequest.of(page,size);
        return organizerRepository.findAll(pageable);
    }


    public List<Organizer> getSorted(String name)
   {
    return organizerRepository.findAll(Sort.by(Sort.Direction.ASC,name));
   }

   public Organizer updateOrganizer(Long id,Organizer organizerdetails)
    {
        organizerdetails.setId(id);
        return organizerRepository.save(organizerdetails);
        
    }

    
    
}



