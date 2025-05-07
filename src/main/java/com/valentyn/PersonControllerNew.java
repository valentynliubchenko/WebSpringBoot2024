package com.valentyn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

//    @GetMapping("/createPersonNew")
    @RequestMapping(method = RequestMethod.POST, value = "/createPersonNew")
    //@ResponseBody
    public Person createPersonNew(@RequestBody Person person, @RequestHeader Map<String, String> headers
    ,@RequestHeader("MyParamHeader") String myParamHeader) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("myParamHeader: " + myParamHeader);

        return personInterface.processingPerson(person);
    }


    @Value("${my.hello}")
    private String hello;

    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public String getInfo() {
        return hello;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/infoname/{name}")
    public String getInfoname(@PathVariable(required = false) String name) {
        return hello + " " + name;
    }
//example call http://localhost:9090/api/infoname/valentyn

    @RequestMapping(method = RequestMethod.GET, value = "/infonamenew")
    public String getInfonamenew(@RequestParam(required = false) String name) {
        return hello + " " + name;
    }
//example http://localhost:9090/api/infonamenew?name=valentyn
}
