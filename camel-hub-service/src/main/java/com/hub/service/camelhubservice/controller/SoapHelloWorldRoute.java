package com.hub.service.camelhubservice.controller;

import com.hub.service.camelhubservice.service.SoapService;
import com.soapservice.client.SayHelloResponse;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class SoapHelloWorldRoute extends RouteBuilder {

    private final SoapService soapService;

    public SoapHelloWorldRoute(final SoapService soapService) {
        this.soapService = soapService;
    }

    @Override
    public void configure() {
        restConfiguration()
                .bindingMode(RestBindingMode.json);

        rest("/hello")
                .get("/soap")
                .produces("application/json")
                .to("direct:hello-world-soap");

        from("direct:hello-world-soap")
                .log("Forward soap call to soap-service.")
                .process(exchange -> exchange.getMessage().setBody(soapService.sayHello("World")))
                .process(extractText())
                .setBody()
                .simple(body().toString());
    }

    private static Processor extractText() {
        return exchange -> exchange.getMessage().setBody(exchange.getMessage().getBody(SayHelloResponse.class).getText());
    }
}
