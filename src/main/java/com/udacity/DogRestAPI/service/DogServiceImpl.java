package com.udacity.DogRestAPI.service;

import com.udacity.DogRestAPI.entity.Dog;
import com.udacity.DogRestAPI.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    public List<String> retrieveDogBreed(){
        return dogRepository.findAllBreed();
    }

    public String retrieveDogBreedById(int id){
       Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        return optionalBreed.orElseThrow(DogNotFoundException::new);
    }

    public List<String> retrieveDogNames(){
        return dogRepository.findAllName();
    }

    public List<Dog> retrieveDogs(){
        return (List<Dog>) dogRepository.findAll();
    }

}