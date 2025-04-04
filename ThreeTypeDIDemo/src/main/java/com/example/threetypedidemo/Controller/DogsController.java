package com.example.threetypedidemo.Controller;


import com.example.threetypedidemo.Service.DogsService;
import com.example.threetypedidemo.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DogsController {
    private DogsService dogsService;


    public DogsController() {
        System.out.println("DogController no argu constructor called");
    }

    public DogsController(DogsService dogsService) {
        System.out.println("argu constructor called");
        this.dogsService = dogsService;
    }

    public DogsService getDogsService() {
        return dogsService;
    }
    @Autowired
    public void setDogsService(DogsService dogsService) {
        System.out.println("DogsService setter call");
        this.dogsService = dogsService;
    }
    public List<Dog> getAllDogs() {
        return dogsService.getDogs();
    }
}
