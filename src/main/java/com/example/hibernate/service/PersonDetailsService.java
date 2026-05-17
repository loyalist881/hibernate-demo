package com.example.hibernate.service;

import com.example.hibernate.entity.Person;
import com.example.hibernate.repository.PersonRepository;
import lombok.NonNull;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;

    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    @NonNull
    public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {
       Person person = personRepository.findByContactEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));

       return User.builder()
               .username(person.getContact().getEmail())
               .password(person.getPassword())
               .authorities(person.getRole())
               .build();
    }
}
