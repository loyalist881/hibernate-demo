package com.example.hibernate.service;

import com.example.hibernate.entity.Person;
import com.example.hibernate.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HibernateService {
    private final PersonRepository personRepository;

    public HibernateService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findByCity(String city) {
        return personRepository.findByCity(city);
    }

    public List<Person> findByAgeLessThanOrderByAgeAsc(int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<Person> findByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}
