package com.example.subscribesystem.repositories;

import com.example.subscribesystem.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<MyUser,Integer> {
    Optional<MyUser> findByEmail(String email);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
