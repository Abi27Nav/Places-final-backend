package com.example.springjwtcustom.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springjwtcustom.entity.*;;

public interface PlacesRepository extends JpaRepository<Places, Integer> {

    
} 