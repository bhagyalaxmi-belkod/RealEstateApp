package com.example.RealEstateApp.Controllers;

import com.example.RealEstateApp.Model.Property;
import com.example.RealEstateApp.Model.User;
import com.example.RealEstateApp.Repository.PropertyRepo;
import com.example.RealEstateApp.Services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PropertyController {

    private PropertyService propertyService;

    public PropertyController( PropertyService propertyService) {

        this.propertyService=propertyService;
    }

    @GetMapping("/bookedProperties")
    public ResponseEntity<List<Property>> bookedProperties() {
        return new ResponseEntity<>(propertyService.findByBookedProperties(),HttpStatus.OK);
    }

    @GetMapping("/availableProperties")
    public ResponseEntity<List<Property>> availableProperties() {
        return new ResponseEntity<>(propertyService.findByAvailableProperties(),HttpStatus.OK);
    }

    @PostMapping("/saveProperty")
    public ResponseEntity<Property> saveProperty(@RequestBody Property property) {

        return new ResponseEntity<>(propertyService.saveProperty(property), HttpStatus.OK);
    }
    @GetMapping("/allProperties")
    public ResponseEntity<List<Property>> ListOfProperties(){
//        List<Property> propertyList=new ArrayList<>();
//        propertyRepo.findAll().forEach(propertyList::add);
        return new ResponseEntity<>(propertyService.getAllProperty(), HttpStatus.OK);
    }

    @RequestMapping("/PropertyId/{id}")
    public Optional<Property> getPropertyById(@PathVariable Long id){
        return propertyService.getProp(id);
    }
}
