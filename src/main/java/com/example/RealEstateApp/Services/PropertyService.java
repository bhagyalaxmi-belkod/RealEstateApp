package com.example.RealEstateApp.Services;

import com.example.RealEstateApp.Model.Property;
import com.example.RealEstateApp.Repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    PropertyRepo propertyRepo;

    public void saveProperty(Property property) {

        propertyRepo.save(property);

    }


    public List<Property> getAllProperty() {

        return propertyRepo.findAll();
    }


    public void deleteProp(Long id) {

        propertyRepo.deleteById(id);

    }

    public Property getProp(Long id) {
        return propertyRepo.getById(id);

    }
}
