package com.example.session15_jsp.exception;

public class PersonNotFoundException extends Exception{
    public PersonNotFoundException() {
    }

    public PersonNotFoundException(String message) {
        super(message);
    }
}
