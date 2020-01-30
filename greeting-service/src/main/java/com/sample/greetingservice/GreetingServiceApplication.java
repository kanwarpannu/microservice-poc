package com.sample.greetingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GreetingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GreetingServiceApplication.class, args);
    }
}
