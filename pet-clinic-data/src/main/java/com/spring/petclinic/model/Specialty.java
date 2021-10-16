package com.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="specialties")
public class Specialty extends BaseEntity{

    @Column(name = "description")
    private String description;

    /*Getter and setter provided*/
    /*
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
     */
}
