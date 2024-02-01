package com.example.session15_jsp.validations;

import com.example.session15_jsp.model.Person;
import com.example.session15_jsp.model.PersonData;

public class PersonValidation {
    public static boolean isDuplicatedNationalCode(String nationalCode) {
        for (Person person:PersonData.getPeople()) {
            if (person.getNationalCode().equals(nationalCode)){
                return true;
            }
        }
        return false;
    }
}
