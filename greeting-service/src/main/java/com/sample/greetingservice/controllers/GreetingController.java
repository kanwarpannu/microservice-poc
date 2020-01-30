package com.sample.greetingservice.controllers;

import com.sample.greetingservice.dtos.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

    public ArrayList<Greeting> greetings = new ArrayList<>(
            Arrays.asList(
                    new Greeting(1, "Hello"),
                    new Greeting(2, "Hi"),
                    new Greeting(3, "Wow")));

    @GetMapping("/greetings")
    public ResponseEntity<Greeting> getGreeting() {
        return new ResponseEntity<>(greetings.get(0), HttpStatus.OK);
    }

    @GetMapping("/greetings/random")
    public ResponseEntity<Greeting> getRandomGreeting() {
        int rnd = new Random().nextInt(greetings.size());
        return new ResponseEntity<>(greetings.get(rnd), HttpStatus.OK);
    }
}
