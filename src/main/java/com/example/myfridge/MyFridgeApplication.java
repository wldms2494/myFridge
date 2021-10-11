package com.example.myfridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyFridgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFridgeApplication.class, args);
    }

}

