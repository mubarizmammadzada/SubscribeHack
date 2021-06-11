package com.example.subscribesystem.service;

import com.example.subscribesystem.repositories.UserRepository;
import com.example.subscribesystem.token.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.subscribesystem.models.MyUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MyUser user = userRepository.findByEmail(email).get();
        String passwword = user.getPassword();
        if (userRepository.existsByEmail(email)) {
            return new User(email, passwword,
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }
    }
}
