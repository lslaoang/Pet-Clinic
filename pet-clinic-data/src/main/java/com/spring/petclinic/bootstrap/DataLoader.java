package com.spring.petclinic.bootstrap;

import com.spring.petclinic.model.Owner;
import com.spring.petclinic.model.Vet;
import com.spring.petclinic.services.OwnerService;
import com.spring.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstname("Laurel");
        owner1.setLastname("Laoang");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstname("Zoe");
        owner2.setLastname("Binarao");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstname("Julius");
        vet1.setLastname("Laoang");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstname("Jamaica");
        vet2.setLastname("Patricia");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded Vets ...");
    }
}
