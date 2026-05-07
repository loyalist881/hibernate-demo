package com.example.hibernate.repository;

import com.example.hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateRepository {
    private final EntityManager entityManager;

    public HibernateRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery(
                        "SELECT p FROM Person p WHERE lower(p.city) = lower(:city)", Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}
