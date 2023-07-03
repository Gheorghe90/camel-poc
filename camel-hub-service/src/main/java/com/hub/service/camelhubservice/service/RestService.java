package com.hub.service.camelhubservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    @Value("${rest.service.url:http://10.5.0.3:8082/hello}")
    private String restServiceUrl;

    private final RestTemplate rest = new RestTemplate();

    public String invokeRestService() {
        return rest.getForObject(restServiceUrl, String.class);
    }
}