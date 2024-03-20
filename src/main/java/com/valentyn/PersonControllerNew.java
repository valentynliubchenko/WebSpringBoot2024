package com.valentyn;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Controller
@Tag(name = "Person API", description = "The  API for Person")
@RestController
@RequestMapping("/api")
public class PersonControllerNew {

    @Autowired
    @Qualifier("personService")
    private PersonInterface personService;

    @RequestMapping(method = RequestMethod.GET, value = "/getPerson")
    //@GetMapping("/createPerson")
    public ResponseEntity<Person> createPerson() {
        return new ResponseEntity<>(personService.createPerson(), HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "My Creating person", description = "This method createPerson")
    //    @RequestMapping(method = RequestMethod.POST, value = "/createPerson")
    @RequestMapping(method = RequestMethod.POST, value = "/createPerson",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Person createPerson(@RequestBody Person person, @RequestHeader("MyParamHeader") String myParamHeader) {
        System.out.println(myParamHeader);
        return personService.processingPerson(person);
    }


    @GetMapping("/createPersonNew")
    //@ResponseBody
    public Person createPersonNew() {
        return personService.createPerson();
    }


    @Value("${my.hello}")
    private String hello;

    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public String getInfo() {
        return hello;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/infoname/{name}")
    public String getInfoname(@Parameter(description = "It is the main parametr") @PathVariable(required = false) String name) {
        return hello + " " + name;
    }
//example call http://localhost:9090/api/infoname/valentyn

    @RequestMapping(method = RequestMethod.GET, value = "/infonamenew")
    public String getInfonamenew(@RequestParam(required = false) String name) {
        return hello + " " + name;
    }
//example http://localhost:9090/api/infonamenew?name=valentyn


}
