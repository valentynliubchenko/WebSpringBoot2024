package com.valentyn;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PersonService implements PersonInterface{
    @Override
    public Person createPerson() {
        Person person = new Person();
        person.setName("testName");
        return person;
    }

    @Override
    public Person processingPerson(Person person) {
        person.setCreateDate(LocalDateTime.now());
        return person;
    }
}
