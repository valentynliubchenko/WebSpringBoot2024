package com.valentyn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonControllerNew {

    @Autowired
    @Qualifier("personService")
    private PersonInterface personInterface;

    @RequestMapping(method = RequestMethod.GET, value = "/createPerson")
    //@GetMapping("/createPerson")
    public ResponseEntity<Person> createPerson() {
        return new ResponseEntity<>(personInterface.createPerson(), HttpStatusCode.valueOf(200));
    }

}