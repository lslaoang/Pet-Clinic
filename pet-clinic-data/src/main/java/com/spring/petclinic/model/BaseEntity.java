package com.spring.petclinic.model;

import java.io.Serializable;

//Setting base entity to put ID and tracker to every object to be created
public class BaseEntity implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
}
