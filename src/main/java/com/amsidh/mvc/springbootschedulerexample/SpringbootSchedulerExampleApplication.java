package com.amsidh.mvc.springbootschedulerexample;

import com.amsidh.mvc.springbootschedulerexample.repository.ShedLockRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJpaRepositories(basePackageClasses = {ShedLockRepository.class})
public class SpringbootSchedulerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSchedulerExampleApplication.class, args);
    }

    @GetMapping
    public String sayHello() {
        return "{\"message\":\"I am working fine\"}";
    }
}
