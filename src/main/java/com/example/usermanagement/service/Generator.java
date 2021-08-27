package com.example.usermanagement.service;

import com.example.usermanagement.service.bean.Age;
import com.example.usermanagement.service.bean.Countries;
import com.example.usermanagement.service.bean.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Component
public class Generator {

    private RestTemplate restTemplate;

    private ExecutorService executorService;

    public Generator(RestTemplate restTemplate, ExecutorService executorService) {
        this.restTemplate = restTemplate;
        this.executorService = executorService;
    }

    public Future<Integer> getAgeByName(String name) {
        return executorService.submit(() -> {
            var uriAge = "https://api.agify.io/?name=" + name;
            var resultForAge = Optional.ofNullable(restTemplate.getForObject(uriAge, Age.class)).get();
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            return resultForAge.getAge();
        });
    }

    public Future<String> getGenderByName(String name) {
        return executorService.submit(() -> {
            var uriGender = "https://api.genderize.io?name=" + name;
            var resultForGender = Optional.ofNullable(restTemplate.getForObject(uriGender, Gender.class)).get();
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            return resultForGender.getGender();
        });
    }

    public Future<String> getNationalityByName(String name) {
        return executorService.submit(() -> {
            var uriNationality = "https://api.nationalize.io/?name=" + name;
            var resultForNationality = Optional.ofNullable(restTemplate.getForObject(uriNationality, Countries.class)).get();
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            return resultForNationality.getCountry().get(0).getCountry_id();
        });
    }
}
