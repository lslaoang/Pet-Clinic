package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Pet;
import com.spring.petclinic.services.PetService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
      super.map.remove(id);
    }

    @Override
    public void delete(Pet object) {
        super.map.remove(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.map.put(object.getId(),object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
