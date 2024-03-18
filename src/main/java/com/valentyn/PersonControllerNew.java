package com.valentyn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequestMapping("/api")
public class PersonControllerNew {

    @Autowired
    @Qualifier("personService")
    private PersonInterface personInterface;

    @RequestMapping(method = RequestMethod.GET, value = "/createPerson")
    //@GetMapping("/createPerson")
    public ResponseEntity<Person> createPerson() {
        return new ResponseEntity<>(personInterface.createPerson(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/createPersonNew")
    //@ResponseBody
    public Person createPersonNew() {
        return personInterface.createPerson();
    }


    @Value("${my.hello}")
    private String hello;
    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public String getInfo(){
        return hello ;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/infoname/{name}")
    public String getInfoname(@PathVariable(required = false) String name){
        return hello + " " + name;
    }
//example call http://localhost:9090/api/infoname/valentyn

    @RequestMapping(method = RequestMethod.GET, value = "/infonamenew")
    public String getInfonamenew(@RequestParam(required = false) String name){
        return hello + " " + name;
    }
//example http://localhost:9090/api/infonamenew?name=valentyn
}
