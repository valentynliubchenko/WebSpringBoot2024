package com.valentyn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonController {

    private Person myPerson;

    @Autowired
    private PersonService personService;

    //private final PersonService personService =new PersonService(); //ручное упрвление

    public Person createPerson() {
        return personService.createPerson();
    }

}
