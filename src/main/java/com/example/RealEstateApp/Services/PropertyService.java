package com.example.RealEstateApp.Services;

import com.example.RealEstateApp.Model.Property;
import com.example.RealEstateApp.Repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;

    public Property saveProperty(Property property) {

        return propertyRepo.save(property);

    }


    public List<Property> getAllProperty() {

        return propertyRepo.findAll();
    }

    public List<Property> findByBookedProperties(){
        return propertyRepo.findByBookedTrue();
    }

    public List<Property> findByAvailableProperties(){
        return propertyRepo.findByBookedFalse();
    }


    public Optional<Property> getProp(Long id) {
        return propertyRepo.findById(id);

    }
}
