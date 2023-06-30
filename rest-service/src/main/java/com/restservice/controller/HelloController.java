package com.restservice.controller;

import com.restservice.domain.Hello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public Hello hello(@RequestParam(value = "name", defaultValue = "World") final String name) {
        LOGGER.info("Rest hello world request received! N: " + counter.incrementAndGet());
        return new Hello(counter.get(), String.format(template, name));
    }
}
