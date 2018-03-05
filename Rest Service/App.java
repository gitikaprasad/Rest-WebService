package com.jpa.ZaaxiitJpa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="com.jpa.ZaaxiitJpa.Repo")
@SpringBootApplication
public class App {

    public static void main(String[] args) {
    	SpringApplication.run(App.class, args);
    }
}