package com.example.hibernate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResponse {
    private String name;
    private String surname;
    private int age;
    private String city;
}
