package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Specialty;
import com.spring.petclinic.model.Vet;
import com.spring.petclinic.services.SpecialtyService;
import com.spring.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialtyService specialtyService;

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialties().size() > 0){
            //POJO for validation of object ID to Generate ID of specialty if null
            object.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null){
                    //save first to HashMap implementation to generate generic ID
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    //get the current HashMap ID and set it to specialty ID
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
