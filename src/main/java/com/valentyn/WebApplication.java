package com.valentyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WebApplication.class);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
//
//        Person person = context.getBean(Person.class);
//        System.out.println(person.getI());
//        person.setName("testName");
//		Person person2 = context.getBean(Person.class);
//		System.out.println(person2.getI());
//
//		person2.setName("testName2");
//		System.out.println(person.getName());
//		System.out.println(person2.getName());
//
//        PersonController personController = context.getBean(PersonController.class);
//        System.out.println(personController.createPerson());
//
//        System.out.println(personController.createPersonService());

    }
}
