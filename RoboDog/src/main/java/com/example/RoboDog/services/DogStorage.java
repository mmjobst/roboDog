package com.example.RoboDog.services;

import com.example.RoboDog.models.Breed;
import com.example.RoboDog.models.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogStorage {
    List<Dog> dogList = new ArrayList<>();


    public void addDog(Dog dog){
        dogList.add(dog);
    }

    public Dog addRandomDog(){
        DogCreator dogCreator = new DogCreator();
        Dog dog = dogCreator.generateRandomDog();
        addDog(dog);
        return dog;
    }

    public List<Dog> getDogList() {
        return dogList;
    }

    public void updateAgeAndBreedByName(String name, int newAge, Breed newBreed){
        Optional<Dog> dogToUpdate = dogList.stream()
                .filter(dog -> dog.getName().equals(name))
                .findFirst();

        dogToUpdate.ifPresent(dog -> dog.updateAgeAndBreed(newAge, newBreed));
    }

    public void deleteDog(String name){
        Optional<Dog> dogToDelete = dogList.stream()
                .filter(dog -> dog.getName().equals(name))
                .findFirst();

        if (dogToDelete.isPresent()){
            dogList.remove(dogToDelete.get());
        }
    }
}
