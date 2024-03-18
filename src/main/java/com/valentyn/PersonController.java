package com.valentyn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    private Person myPerson;

//    @Autowired
//    private PersonInterface personService;

//    @Autowired
//    private PersonInterface customPersonService;

    @Autowired
    @Qualifier("customPersonService")
    private PersonInterface service;

    //private final PersonService personService =new PersonService(); //ручное упрвление

    @RequestMapping
    public Person createPerson() {
        //return customPersonService.createPerson();
        return service.createPerson();
    }

}
