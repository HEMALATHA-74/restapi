package com.example.apiproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.apiproject.entity.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    


}
