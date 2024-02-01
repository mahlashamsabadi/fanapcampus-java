package com.example.session15_jsp.model;

import com.example.session15_jsp.exception.PersonValidationException;
import com.example.session15_jsp.validations.PersonValidation;

public class Person {
    private String firstname;
    private String lastname;
    private String nationalCode;
    private Integer id;
    private static Integer count=0;

    public Person(String firstname, String lastname, String nationalCode) throws PersonValidationException {
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setNationalCode(nationalCode);
        count++;
        this.id = count;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) throws PersonValidationException {
        if(PersonValidation.isDuplicatedNationalCode(nationalCode)){
            throw new PersonValidationException(String.format("National code %s is duplicated",nationalCode));
        }
        this.nationalCode = nationalCode;
    }
}
