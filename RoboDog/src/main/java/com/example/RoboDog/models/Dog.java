package com.example.RoboDog.models;

public class Dog {
    private int age;
    private String name;
    private Breed breed;

    public Dog(int age, String name, Breed breed) {
        this.age = age;
        this.name = name;
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Breed getBreed() {
        return breed;
    }

    public void updateAgeAndBreed(int newAge, Breed newBreed){
        this.age = newAge;
        this.breed = newBreed;
    }
}
