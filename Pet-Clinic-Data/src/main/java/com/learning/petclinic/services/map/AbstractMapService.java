package com.learning.petclinic.services.map;

import java.util.*;

public abstract class AbstractMapService<Type, ID extends Long> {

    protected Map<Long, Type> map = new HashMap<>();

    Type findById(ID id) {
        return map.get(id);
    }

    Set<Type> findAll() {
        return new HashSet<>(map.values());
    }

    Type save(ID id, Type object) {


        map.put(id, object);

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(Type object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        return Collections.max(map.keySet()) + 1;
    }

}
