package com.learning.petclinic.services.map;

import com.learning.petclinic.model.Visit;
import com.learning.petclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit save(Visit object) {

        if (object.getPet() == null ||
            object.getPet().getId() == null ||
            object.getPet().getOwner() == null ||
            object.getPet().getOwner().getId() == null)
        {
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}