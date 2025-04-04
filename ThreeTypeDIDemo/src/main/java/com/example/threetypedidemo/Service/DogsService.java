package com.example.threetypedidemo.Service;

import com.example.threetypedidemo.Dao.DogRepository;
import com.example.threetypedidemo.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DogsService {

    private DogRepository repository;

    public DogsService() {
        System.out.println("DogService no arg contructor called");
    }

    public DogsService(DogRepository repository) {
        System.out.println("Argument Contructor called");
        this.repository = repository;
    }
    @Autowired
    public void setRepository(DogRepository repository) {
        System.out.println("Dogservice setter call");
        this.repository = repository;
    }
    public List<Dog> getDogs() {
        return repository.getAllDog();
    }
}
