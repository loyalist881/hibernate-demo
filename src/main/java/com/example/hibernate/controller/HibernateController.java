package com.example.hibernate.controller;

import com.example.hibernate.entity.Person;
import com.example.hibernate.service.HibernateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HibernateController {
    private final HibernateService hibernateService;

    public HibernateController(HibernateService hibernateService) {
        this.hibernateService = hibernateService;
    }

    @GetMapping("/persons/by-city")
    public List<Person> findByCity(@RequestParam String city) {
        return hibernateService.findByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> findByAgeLessThanOrderByAgeAsc(@RequestParam int age) {
        return hibernateService.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<Person> findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return hibernateService.findByNameAndSurname(name, surname);
    }
}

