package com.example.challenge.service;

import com.example.challenge.entities.MutantGene;
import com.example.challenge.repositories.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MutantService {

    @Autowired
    MutantRepository mutantRepository;

    @Transactional
    public List<MutantGene> findAll() {
        List<MutantGene> entities = mutantRepository.findAll();
        return entities;
    }

    @Transactional
    public MutantGene save(MutantGene entity) {
        entity = mutantRepository.save(entity);
        return entity;
    }

    @Transactional
    public boolean deleteMutantById(Long id) {
        return mutantRepository.deleteMutantById(id);
    }

}
