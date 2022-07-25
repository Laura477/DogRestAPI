package com.udacity.DogRestAPI.service;

import com.udacity.DogRestAPI.entity.Dog;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DogService {
//    List<String> retrieveDogBreed();
//
//    String retrieveDogBreedById(Long id);
//
//    List<String> retrieveDogName();
    List<Dog> retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(int id);
    List<String> retrieveDogNames();
}
