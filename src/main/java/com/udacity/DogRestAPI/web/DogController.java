package com.udacity.DogRestAPI.web;

import com.udacity.DogRestAPI.entity.Dog;
import com.udacity.DogRestAPI.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code=401, message = "Unauthorized access."),
        @ApiResponse(code=404, message = "The requested resource was not found. If you were looking for breed by id, make sure to enter a valid id (integer between 1 and 5)."),
        @ApiResponse(code=500, message = "This is an internal server error.")
})
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getDogBreeds(){
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getDogNames(){
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}/breed")
    public ResponseEntity<String> getBreedById(@PathVariable int id){
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<>(breed, HttpStatus.OK);
    }
}
