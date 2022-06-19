package com.learning.petclinic.services;

import com.learning.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
