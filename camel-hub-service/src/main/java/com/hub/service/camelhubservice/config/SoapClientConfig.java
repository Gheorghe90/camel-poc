package com.hub.service.camelhubservice.config;

import com.hub.service.camelhubservice.service.SoapService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Value("${soap.service.url:http://10.5.0.4:8081/ws}")
    private String soapServiceUrl;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.soapservice.client");
        return marshaller;
    }
    @Bean
    public SoapService countryClient(Jaxb2Marshaller marshaller) {
        SoapService client = new SoapService();
        client.setDefaultUri(soapServiceUrl);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}