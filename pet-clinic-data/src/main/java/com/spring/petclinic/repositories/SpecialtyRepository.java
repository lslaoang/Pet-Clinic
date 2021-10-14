package com.spring.petclinic.repositories;

import com.spring.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
}
