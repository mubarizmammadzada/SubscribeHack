package com.example.subscribesystem.service;

import com.example.subscribesystem.dao.DomainData;
import com.example.subscribesystem.models.Platform;
import com.example.subscribesystem.repositories.domainRepository;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class domainService implements domainServices {

    domainRepository domainRepository;
    DomainData domainData;


    public domainService(domainRepository domainRepository, DomainData domainData) {
        this.domainRepository = domainRepository;
        this.domainData = domainData;
    }

    @Override
    public Platform getDomainByName(String domainName) {
        return domainData.getDomainByName(domainName);
    }

    @Override
    public List<Platform> getAllPlatforms() {
        return domainData.getAllPlatforms();
    }

    @Override
    public boolean checkDomainAvailability(String apiKey, String domainName, String credits) throws IOException {
        HttpGet request = new HttpGet("https://domain-availability.whoisxmlapi.com/api/v1?apiKey=" + apiKey + "&domainName=" + domainName + "&credits=" + credits + "");
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        result = result.replace("{", "").replace("}", "").replace(":", ",");
        String[] strings = result.split(",");
        String platFormName = strings[strings.length - 1].replace('"', ' ').trim();
        if (result.contains("UNAVAILABLE")) {

            if (!domainRepository.existsByPlatformName(platFormName)) {
                Platform platform = new Platform();

                platform.setPrice(Math.round(Math.random() * 50));
                platform.setName(strings[strings.length - 1].replace('"', ' ').trim());
                domainRepository.save(platform);
            }
            return true;
        }
        return false;
    }
}
