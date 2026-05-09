package com.example.hibernate.repository;

import com.example.hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(value = "SELECT * FROM persons WHERE city = :city", nativeQuery = true)
    List<Person> findByCity(@Param("city") String city);

    @Query(value = "SELECT * FROM persons WHERE age < :age ORDER BY age", nativeQuery = true)
    List<Person> findByAgeLessThanOrderByAgeAsc(@Param("age") int age);

    @Query(value = "SELECT * FROM persons WHERE name = :name AND surname = :surname", nativeQuery = true)
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
