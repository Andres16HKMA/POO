package com.ingenieria_de_software;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class App {

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @PostConstruct
    public void init() {
        // Imprime la URL de la base de datos
        System.out.println("URL de la base de datos: " + environment.getProperty("spring.datasource.url"));
    }
}
