package com.example.subscribesystem.repositories;

import com.example.subscribesystem.models.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface domainRepository extends JpaRepository<Platform, Integer> {
    @Query(value = "SELECT CASE WHEN EXISTS (SELECT *  FROM platform p WHERE p.name =:platformName )THEN true ELSE FALSE END", nativeQuery = true)
    boolean existsByPlatformName(String platformName);
    @Query(value = "SELECT *  FROM platform p WHERE p.name =:name", nativeQuery = true)
    Platform getPlatformByName(String name);
}
