package com.valentyn;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class Person {
    private static int i;
    private String name;
    private String year;
    private LocalDateTime createDate;

    public Person() {
        i++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Person.i = i;
    }
    public static void setI2(int i) {
        Person.i = i;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    //    @PostConstruct
//    public void init()    {
//        System.out.println("PostConstruct init");
//    }
//
//    @PreDestroy
//    public void destroy()    {
//        System.out.println("PreDestroy destroy");
//    }


}
