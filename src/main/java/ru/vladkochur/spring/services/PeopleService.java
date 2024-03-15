package ru.vladkochur.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vladkochur.spring.models.Person;
import ru.vladkochur.spring.repositories.PeopleRepository;
import java.util.List;

@Service
@Transactional(readOnly = true)  //По умолчанию
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        System.out.println("Debug");
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Transactional //Перекрывает аннотацию над классом
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);   //Используется и для добавления, и для сохранения
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
}
