package com.example.apiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.apiproject.entity.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

    // Custom queries can be added here if needed

}
