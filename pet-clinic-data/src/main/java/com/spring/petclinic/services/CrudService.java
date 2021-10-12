package com.spring.petclinic.services;

import java.util.Set;

//Copy of CRUDs service interface
public interface CrudService<T,ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T object);

    void delete(T object);
    void deleteById(ID id);

}
