package com.hub.service.camelhubservice.controller;

import com.hub.service.camelhubservice.service.RestService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestHelloWorldRoute extends RouteBuilder {

    private final RestService restService;

    public RestHelloWorldRoute(final RestService restService) {
        this.restService = restService;
    }

    @Override
    public void configure() {
        restConfiguration()
                .bindingMode(RestBindingMode.json);

        rest("/hello")
                .get("/rest")
                .produces("application/json")
                .to("direct:hello-world-rest");

        from("direct:hello-world-rest")
                .log("Forward rest call to rest-service.")
                .process(exchange -> exchange.getMessage().setBody(restService.invokeRestService()))
                .setBody()
                .simple(body().toString());
    }
}
