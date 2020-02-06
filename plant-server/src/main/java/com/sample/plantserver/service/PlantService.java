package com.sample.plantserver.service;

import com.sample.plantserver.dtos.Greeting;
import com.sample.plantserver.dtos.PlantInfo;
import com.sample.plantserver.entities.Plant;
import com.sample.plantserver.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<List<Plant>> getPlants() {
        List<Plant> plantList = plantRepository.findAll();
        return ResponseEntity.ok(plantList);
    }

    public ResponseEntity<Plant> getPlant(long id) {
        Plant plant = plantRepository.findById(id).orElse(null);
        return ResponseEntity.ok(plant);
    }

    public ResponseEntity<Plant> createPlant(Plant plant) {
        Plant plantInfo = plantRepository.save(plant);
        return new ResponseEntity(plantInfo, HttpStatus.CREATED);
    }

    public ResponseEntity<Plant> updatePlant(Plant plant, long id) {
        Optional<Plant> plantOptional = plantRepository.findById(id);

        if (plantOptional.isPresent()) {
            plant.setId(plantOptional.get().getId());
        } else {
            return ResponseEntity.ok(null);
        }
        Plant plantInfo = plantRepository.save(plant);
        return ResponseEntity.ok(plantInfo);
    }


    public ResponseEntity<String> deletePlant(long id) {
        plantRepository.deleteById(id);
        return new ResponseEntity("Plant deleted", HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<String> getRandomPlantGreeting(long id) {
        String endResponse = "";
        ResponseEntity<Greeting> greetingResponse = restTemplate.getForEntity("http://greetingservice/api/v1/greetings/random", Greeting.class);

        Optional<Plant> plant = plantRepository.findById(id);
        if (plant.isPresent()) {
            endResponse = greetingResponse.getBody().getMessage() +" " + plant.get().getName();
        }
        return ResponseEntity.ok(endResponse);
    }
}
