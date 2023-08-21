package com.example.RealEstateApp.Repository;

import com.example.RealEstateApp.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepo extends JpaRepository<Property, Long> {

}
