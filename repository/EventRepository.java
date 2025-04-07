package com.example.apiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiproject.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Long>{
    

}
