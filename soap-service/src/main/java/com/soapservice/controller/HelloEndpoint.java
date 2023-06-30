package com.soapservice.controller;

import com.soapservice.example.SayHelloRequest;
import com.soapservice.example.SayHelloResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.concurrent.atomic.AtomicLong;


@Endpoint
public class HelloEndpoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloEndpoint.class);

	private static final String NAMESPACE_URI = "http://soapservice.com/example";

	private final AtomicLong counter = new AtomicLong();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sayHelloRequest")
	@ResponsePayload
	public SayHelloResponse sayHello(@RequestPayload SayHelloRequest request) {
		LOGGER.info("Soap hello world request received! N: " + counter.incrementAndGet());

		SayHelloResponse response = new SayHelloResponse();
		response.setText(request.getText());
		return response;
	}
}
