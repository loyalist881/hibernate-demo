package com.example.hibernate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    private String name;
    private String surname;
    private int age;
    private String city;
    private String email;
    private String phoneNumber;
    private String clearTextPassword;
}
