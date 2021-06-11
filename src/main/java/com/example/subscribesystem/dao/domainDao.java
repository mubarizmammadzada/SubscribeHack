package com.example.subscribesystem.dao;

import com.example.subscribesystem.models.Platform;

import java.util.List;

public interface domainDao {
    Platform getDomainByName(String domainName);
    List<Platform> getAllPlatforms();
}
