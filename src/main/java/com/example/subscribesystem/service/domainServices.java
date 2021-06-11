package com.example.subscribesystem.service;

import com.example.subscribesystem.models.Platform;

import java.io.IOException;
import java.util.List;

public interface domainServices {
    boolean checkDomainAvailability(String apiKey, String domainName, String credits) throws IOException;
    Platform getDomainByName(String domainName);
    List<Platform> getAllPlatforms();
}
