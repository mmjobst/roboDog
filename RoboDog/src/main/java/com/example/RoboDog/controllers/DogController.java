package com.example.RoboDog.controllers;

import com.example.RoboDog.models.Breed;
import com.example.RoboDog.models.Dog;

import com.example.RoboDog.services.DogStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class DogController {
    DogStorage dogStorage;

    public DogController(DogStorage dogStorage) {
        this.dogStorage = dogStorage;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getDogs(){
        List<Dog> dogs = dogStorage.getDogList();
        return ResponseEntity.ok(dogs);
    }

    @GetMapping("/random")
    public ResponseEntity<Dog> addRandomDog(){
        Dog newRandomDog = dogStorage.addRandomDog();
        return ResponseEntity.ok(newRandomDog);
    }

    @PostMapping("/newDog")
    public ResponseEntity<String>  getNewDog(@RequestBody Dog newDog){
        dogStorage.addDog(newDog);
        return ResponseEntity.ok("Request processed successfully");
    }

    @PutMapping("/update/{dogName}")
    public ResponseEntity<String>  updateDog(@PathVariable String dogName, @RequestBody Map<String, Object> request){
        int age = (int) request.get("age");
        Breed breed = Breed.valueOf((String) request.get("breed"));
        dogStorage.updateAgeAndBreedByName(dogName, age, breed);
        return ResponseEntity.ok("Request processed successfully");
    }


}
