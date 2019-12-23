package com.nglb.students.domain;

import lombok.Data;

@Data
public class User {
    private String lastName;
    private String firstName;


    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
