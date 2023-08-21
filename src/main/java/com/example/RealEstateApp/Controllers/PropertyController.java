package com.example.RealEstateApp.Controllers;

import com.example.RealEstateApp.Model.Property;
import com.example.RealEstateApp.Model.User;
import com.example.RealEstateApp.Repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PropertyController {

    @Autowired
    PropertyRepo propertyRepo;

    public PropertyController(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    @PostMapping("/addProperty")
    public @ResponseBody Property registerUser(@RequestBody Property property) {
        return property;
    }


    @PostMapping("/SaveProperty")
    public ResponseEntity<Property> saveUser(@RequestBody Property property) {
        Property propObj=propertyRepo.save(property);
//        Optional<User> optional = userService.getUserEmail(user.getEmail());
//
//        if (optional.isEmpty()) {
//            userService.saveUser(user);
//        }
        return new ResponseEntity<>(propObj, HttpStatus.OK);
    }
    @GetMapping("/properties")
    public ResponseEntity<List<Property>> ListOfProperties(){
        List<Property> propertyList=new ArrayList<>();
        propertyRepo.findAll().forEach(propertyList::add);
        return new ResponseEntity<>(propertyList, HttpStatus.OK);
    }
}
