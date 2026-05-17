package com.example.hibernate.controller;

import com.example.hibernate.dto.PersonResponse;
import com.example.hibernate.entity.Person;
import com.example.hibernate.service.HibernateService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

    private PersonResponse mapToResponse(Person person) {
        PersonResponse personResponse = new PersonResponse();
        personResponse.setName(person.getName());
        personResponse.setSurname(person.getSurname());
        personResponse.setAge(person.getAge());
        personResponse.setCity(person.getCity());
        return personResponse;
    }

    @GetMapping("/persons/by-city")
    public List<PersonResponse> findByCity(@RequestParam String city) {
        return hibernateService.findByCity(city).stream()
                .map(this::mapToResponse)
                .toList();
    }

    @GetMapping("/persons/by-age")
    public List<PersonResponse> findByAgeLessThanOrderByAgeAsc(@RequestParam int age) {
        return hibernateService.findByAgeLessThanOrderByAgeAsc(age).stream()
                .map(this::mapToResponse)
                .toList();
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<PersonResponse> findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return hibernateService.findByNameAndSurname(name, surname)
                .map(this::mapToResponse);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_READ', 'ROLE_WRITE', 'ROLE_DELETE')")
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @Secured({"ROLE_READ"})
    @GetMapping("/read")
    public String read() {
        return "Read";
    }

    @RolesAllowed({"WRITE"})
    @GetMapping("/write")
    public String write() {
        return "Write";
    }

    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    @GetMapping("/or")
    public String or() {
        return "Access granted";
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/token")
    public String token(@RequestParam String username) {
        return "token";
    }
}

