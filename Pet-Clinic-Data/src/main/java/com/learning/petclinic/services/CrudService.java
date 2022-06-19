package com.learning.petclinic.services;

import java.util.Set;

public interface CrudService<Type, ID> {

    Type findById(ID id);

    Set<Type> findAll();

    Type save(Type object);

    void delete(Type object);

    void deleteById(ID id);
}
