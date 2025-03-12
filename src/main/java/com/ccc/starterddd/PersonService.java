package com.ccc.starterddd;

import org.springframework.beans.factory.annotation.Autowired;


public class PersonService {
    @Autowired
    private Person person;


    public String autoIntegrationStarterAndRunMethod() {

        System.out.println(person);
        return person.toString();
    }


}
