package com.example.RoboDog.services;

import com.example.RoboDog.models.Breed;
import com.example.RoboDog.models.Dog;

import java.util.Random;

public class DogCreator {
    private String[] namePool = {
            "Buddy", "Lola", "Charlie", "Molly", "Max", "Sadie", "Cooper", "Lucy", "Rocky", "Daisy",
            "Oliver", "Luna", "Bailey", "Coco", "Tucker", "Stella", "Duke", "Roxy", "Bentley", "Zoe"
    };

    private Breed breeds[] = Breed.values();


    public Dog generateRandomDog(){
        int maxAge = 16;
        return new Dog(randNumberFromTo(maxAge + 1), namePool[randNumberFromTo(namePool.length - 1)], breeds[randNumberFromTo(breeds.length - 1)]);

    }

    public int randNumberFromTo(int max){
        Random random = new Random();
        return random.nextInt(max + 1);
    }

}
