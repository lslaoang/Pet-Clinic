package com.spring.petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

//Generic object for a person
@MappedSuperclass
public class Person extends BaseEntity{

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
