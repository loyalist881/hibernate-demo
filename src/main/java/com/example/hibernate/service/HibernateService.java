package com.example.hibernate.service;

import com.example.hibernate.entity.Person;
import com.example.hibernate.repository.HibernateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateService {
    private final HibernateRepository hibernateRepository;

    public HibernateService(HibernateRepository hibernateRepository) {
        this.hibernateRepository = hibernateRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        return hibernateRepository.getPersonsByCity(city);
    }
}
