package com.example.RealEstateApp.Services;

import com.example.RealEstateApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.RealEstateApp.Model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;

    public void saveUser(User user){
        userRepo.save(user);
    }

    public Optional<User> getUser(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }

    public Optional<User> getUserEmail(String email) {

        return userRepo.findByEmail(email);
    }
}
