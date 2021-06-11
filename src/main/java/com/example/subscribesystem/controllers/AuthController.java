package com.example.subscribesystem.controllers;

import com.example.subscribesystem.dto.UserPostDTO;
import com.example.subscribesystem.repositories.UserRepository;
import com.example.subscribesystem.models.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/auth")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class AuthController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody UserPostDTO user){
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body("This username already exist!!");
        }
        MyUser user1=new MyUser(user.getName(),user.getSurname(),user.getEmail()
        ,encoder.encode(user.getPassword()),user.getUsername(),false);
        userRepository.save(user1);
        return ResponseEntity.ok(user1);
    }


}
