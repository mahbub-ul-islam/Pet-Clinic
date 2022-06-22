package com.learning.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<Type, ID> {

    protected Map<ID, Type> map = new HashMap<>();

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
}
