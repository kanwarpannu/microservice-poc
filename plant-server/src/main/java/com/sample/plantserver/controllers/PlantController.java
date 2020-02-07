package com.sample.plantserver.controllers;

import com.sample.plantserver.entities.Plant;
import com.sample.plantserver.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping("/plants")
    public ResponseEntity<List<Plant>> getAllPlants() {
        return plantService.getPlants();
    }

    @GetMapping("/plants/{id}")
    public ResponseEntity<?> getPlant(@PathVariable("id") long id) {
        return plantService.getPlant(id);
    }

    @PostMapping("/plants")
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant) {
        return plantService.createPlant(plant);
    }

    @PutMapping("/plants/{id}")
    public ResponseEntity<?> updatePlant(@RequestBody Plant plant, @PathVariable("id") long id) {
        return plantService.updatePlant(plant, id);
    }

    @DeleteMapping("/plants/{id}")
    public ResponseEntity<String> deletePlant(@PathVariable("id") long id) {
        return plantService.deletePlant(id);
    }

    @GetMapping("/plants/{id}/greet")
    public ResponseEntity<String> getPlantGreeting(@PathVariable("id") long id) {
        return plantService.getRandomPlantGreeting(id);
    }
}