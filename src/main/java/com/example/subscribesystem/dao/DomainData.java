package com.example.subscribesystem.dao;

import com.example.subscribesystem.models.Platform;
import com.example.subscribesystem.repository.domainRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DomainData implements domainDao {

    domainRepository domainRepository;

    public DomainData(domainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }
    @Override
    public Platform getDomainByName(String domainName) {
        return domainRepository.getPlatformByName(domainName);
    }

    @Override
    public List<Platform> getAllPlatforms() {
        return domainRepository.findAll();
    }
}
