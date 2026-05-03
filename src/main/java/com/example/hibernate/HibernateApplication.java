package com.example.hibernate;

import com.example.hibernate.entity.Contact;
import com.example.hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        List<Person> persons = List.of(
                Person.builder()
                        .name("Pavel")
                        .surname("Sokolov")
                        .age(23)
                        .city("Novosibirsk")
                        .contact(Contact.builder()
                                .email("pavel@mail.ru")
                                .phone_number("111-111")
                                .build())
                        .build(),
                Person.builder()
                        .name("Anna")
                        .surname("Ivanova")
                        .age(28)
                        .city("Moscow")
                        .contact(Contact.builder()
                                .email("anna@mail.ru")
                                .phone_number("222-222")
                                .build())
                        .build(),
                Person.builder()
                        .name("Ivan")
                        .surname("Smirnov")
                        .age(35)
                        .city("Moscow")
                        .contact(Contact.builder()
                                .email("ivan@mail.ru")
                                .phone_number("333-333")
                                .build())
                        .build()
        );
        for (Person person : persons) {
            entityManager.persist(person);
        }
    }
}
