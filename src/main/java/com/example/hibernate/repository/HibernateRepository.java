package com.example.hibernate.repository;

import com.example.hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HibernateRepository {
    private final EntityManager entityManager;

    public HibernateRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getPersonsByCity(String city) {
        List<Person> allPerson = entityManager.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();

        return allPerson.stream()
                .filter(person -> person.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
}
