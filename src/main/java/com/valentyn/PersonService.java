package com.valentyn;

import org.springframework.stereotype.Component;

@Component
public class PersonService implements PersonInterface{
    @Override
    public Person createPerson() {
        Person person = new Person();
        person.setName("testName");
        return person;
    }
}
