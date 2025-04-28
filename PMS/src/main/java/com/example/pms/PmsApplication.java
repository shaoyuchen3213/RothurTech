package com.example.pms;



import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PmsApplication {

    private static final Logger LOG= LoggerFactory.getLogger(PmsApplication.class);
    public static void main(String[] args) {


        SpringApplication.run(PmsApplication.class, args);
        LOG.info("Success Start!");
    }

}
