package com.example.RealEstateApp.Repository;

import com.example.RealEstateApp.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Long> {
 public List<Property> findByBookedTrue();

 public List<Property> findByBookedFalse();

 public Optional< Property > findById(Long id);

}
