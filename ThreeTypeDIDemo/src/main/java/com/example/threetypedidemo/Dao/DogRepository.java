package com.example.threetypedidemo.Dao;

import com.example.threetypedidemo.model.Dog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DogRepository {
    public DogRepository() {
        System.out.println("DogReponsitory no-argument onsturctor called");
    }

    public List<Dog> getAllDog() {
        System.out.println("DogRepository");
        return null;
    }
}
