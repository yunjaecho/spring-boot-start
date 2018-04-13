package com.yunjae.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteService {

    private RestTemplate restTemplate;

    public String remote() {
        return "Remote Service";
    }

    public RemoteService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }


    public String getName() {
        return restTemplate.getForObject("/food", String.class);
    }
}
