package com.xocayev.multitanancy.demoapp.config;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * Following class is using to get unique ID using sequence name
 */

@Service
public class SequenceHandler {
    private final EntityManager entityManager;

    public SequenceHandler(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * @param sequenceName String
     * @return ID as String , It can be parse any type of number (Long ,Integer)
     */

    @Transactional
    public String generateId(String sequenceName) {

        String nextId = entityManager
                .createNativeQuery("select nextval('" + sequenceName + "')")
                .getSingleResult().toString();

        return nextId;
    }
}
