package ru.vladkochur.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.vladkochur.spring.models.Person;
import ru.vladkochur.spring.repositories.PeopleRepository;
import ru.vladkochur.spring.services.PeopleService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class PersonValidator implements Validator {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonValidator(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if (person.getDateOfBirth() == null ||
                person.getDateOfBirth().before(new Date(-2208999600000L)) ||    // date of 01.01.1900 in long
                person.getDateOfBirth().after(new Date())) {

            errors.rejectValue("dateOfBirth", "", "Write correct date after 01-01-1900");
        }
        if (peopleRepository.findOptionalByEmail(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "This email is already in use");
        }
    }
}
