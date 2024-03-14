package ru.vladkochur.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vladkochur.spring.models.Person;

@Repository                                       // class, тип данных Primary key
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
