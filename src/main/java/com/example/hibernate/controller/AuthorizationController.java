package com.example.hibernate.controller;

import com.example.hibernate.dto.RegistrationRequest;
import com.example.hibernate.entity.Contact;
import com.example.hibernate.entity.Person;
import com.example.hibernate.repository.PersonRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthorizationController(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request) {
        Contact contact = Contact.builder()
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();

        Person person = Person.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .age(request.getAge())
                .city(request.getCity())
                .contact(contact)
                .password(passwordEncoder.encode(request.getClearTextPassword()))
                .role("ROLE_USER")
                .build();

        personRepository.save(person);
        return "пользователь " + request.getName() + "успешно зарегистрирован!";
    }
}
