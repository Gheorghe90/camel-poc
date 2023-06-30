package com.hub.service.camelhubservice.service;

import com.soapservice.client.SayHelloRequest;
import com.soapservice.client.SayHelloResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SoapService extends WebServiceGatewaySupport {

    public SayHelloResponse sayHello(final String text) {
        final SayHelloRequest request = new SayHelloRequest();
        request.setText(text);

        return (SayHelloResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}