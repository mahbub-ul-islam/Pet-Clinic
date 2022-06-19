package com.learning.petclinic.services;

import com.learning.petclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long> {

    Vet findByLastName(String lastName);
}
