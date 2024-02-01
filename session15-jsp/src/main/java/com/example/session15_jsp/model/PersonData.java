package com.example.session15_jsp.model;

import com.example.session15_jsp.exception.PersonNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class PersonData {
    private static List<Person> people = new ArrayList<>();


    public static List<Person> getPeople() {
        return people;
    }
    public static Person findByID(int personId) throws PersonNotFoundException {
        for (Person person:people) {
            if (person.getId().equals(personId)){
                return person;
            }
        }
        throw new PersonNotFoundException(String.format("person with id %s not found" , personId));
    }
}
