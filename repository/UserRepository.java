package com.example.apiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.apiproject.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Custom query method to find a user by email
    Optional<User> findByEmail(String email);
    //JPQL Methods
    @Query("SELECT u FROM User u where u.name=:Name")
    public List<User> findByUserName(@Param("Name") String name);
}
