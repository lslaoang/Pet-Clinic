package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Owner;
import com.spring.petclinic.model.Pet;
import com.spring.petclinic.services.OwnerService;
import com.spring.petclinic.services.PetService;
import com.spring.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.map.remove(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null){
            //If object to be saved has no ID, add it to petTypeService(which is a CRUD) and set its ID base on it.
            if(object.getPets() != null){
                //Check each pet for PetType ID
                object.getPets().forEach(pet->{
                    if(pet.getPetType()!=null){
                        //If ID is null save it first to petTypeService
                        if(pet.getPetType().getId() == null){
                            //Persisted to CRUD service
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else{
                        throw new RuntimeException("Pet Type is required");
                    }
                    //Finally, set the ID of the pet if null
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else{
            return null;
        }
    }

    @Override
    public Owner findByLastName(String lastName) {
        return super.map.get(lastName);
    }
}
