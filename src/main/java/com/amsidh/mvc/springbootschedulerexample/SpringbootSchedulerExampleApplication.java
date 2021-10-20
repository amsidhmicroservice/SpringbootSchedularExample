package com.amsidh.mvc.springbootschedulerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootSchedulerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSchedulerExampleApplication.class, args);
    }

    @GetMapping
    public String sayHello() {
        return "{\"message\":\"I am working fine\"}";
    }
}
