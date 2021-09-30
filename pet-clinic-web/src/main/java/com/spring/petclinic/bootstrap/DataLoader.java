package com.spring.petclinic.bootstrap;

import com.spring.petclinic.model.Owner;
import com.spring.petclinic.model.PetType;
import com.spring.petclinic.model.Vet;
import com.spring.petclinic.services.OwnerService;
import com.spring.petclinic.services.PetTypeService;
import com.spring.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Laurel");
        owner1.setLastName("Laoang");

        Owner owner2 = new Owner();
        owner2.setFirstName("Zoe");
        owner2.setLastName("Binarao");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Julius");
        vet1.setLastName("Laoang");

        Vet vet2 = new Vet();
        vet2.setFirstName("Jamaica");
        vet2.setLastName("Patricia");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded Vets ...");
    }
}
