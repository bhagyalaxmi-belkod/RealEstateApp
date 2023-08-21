package com.example.RealEstateApp.Controllers;

import ch.qos.logback.core.CoreConstants;
import com.example.RealEstateApp.Model.Property;
import com.example.RealEstateApp.Repository.UserRepo;
import com.example.RealEstateApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.RealEstateApp.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    @PostMapping("/userRegister")
//    public @ResponseBody User registerUser(@RequestBody User user) {
//        User userObj=userRepo.save(user);
//        return user;
//    }


    @PostMapping("/UserSignUp")
    public ResponseEntity<User> saveUser(@RequestBody User user) {

        Optional<User> optional = userRepo.findByEmail(user.getEmail());
        System.out.println("Optional value:========"+optional);
        if (optional.isEmpty()) {
            User userObj=userRepo.save(user);
            return new ResponseEntity<>(userObj, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatusCode.valueOf(401));
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getPropertiesList(){
        List<User> userList= new ArrayList<>();
        userRepo.findAll().forEach(userList::add);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


}
