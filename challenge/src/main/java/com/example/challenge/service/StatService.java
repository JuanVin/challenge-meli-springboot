package com.example.challenge.service;


import com.example.challenge.entities.Stats;
import com.example.challenge.repositories.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class StatService {

    @Autowired
    StatRepository statRepository;

    @Transactional
    public Stats findOne(Long id) {
        return statRepository.getById(id);
    }

    @Transactional
    public Long count() throws Exception {
        try {
            return statRepository.count();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Stats save(Stats entity) throws Exception {
        try {
            entity = statRepository.save(entity);
            return entity;

        } catch (Exception e) {
            throw new Exception("La concha de la lorarrarara");
        }
    }


    @Transactional
    public Stats update(Long id, Stats entity) throws Exception {
        try {
            Stats entityOp = statRepository.getById(id);
            entityOp.setCount_human_dna(entity.getCount_human_dna());
            entityOp.setCount_mutant_dna(entity.getCount_mutant_dna());
            statRepository.save(entityOp);
            return entityOp;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
