package com.valentyn.services;

import com.valentyn.Person;
import com.valentyn.PersonInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service("customPersonService")
//@Component
public class PersonService implements PersonInterface {
    @Override
    public Person createPerson() {
        Person person = new Person();
        person.setName("newName");
        return person;
    }

    @Override
    public Person processingPerson(Person person) {
        person.setCreateDate(LocalDateTime.now());
        return person;
    }

}
