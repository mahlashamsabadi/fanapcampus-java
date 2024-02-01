package com.example.session15_jsp.exception;

public class PersonValidationException extends Exception{
    public PersonValidationException() {
    }

    public PersonValidationException(String message) {
        super(message);
    }
}
