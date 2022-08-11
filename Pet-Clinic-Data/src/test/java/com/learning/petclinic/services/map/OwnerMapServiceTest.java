package com.learning.petclinic.services.map;

import com.learning.petclinic.model.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ownerId = 1L;

    final String lastname = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastname).build());
    }


    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        Assertions.assertEquals(ownerId, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        Assertions.assertEquals(1, ownerSet.size());
    }

    @Test
    void saveExistId() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerMapService.save(owner2);

        Assertions.assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        Assertions.assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        Assertions.assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        Assertions.assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerMapService.findByLastName(lastname);

        Assertions.assertNotNull(smith);
        Assertions.assertEquals(ownerId, smith.getId());
//        Assertions.assertNull(smith);
    }
}