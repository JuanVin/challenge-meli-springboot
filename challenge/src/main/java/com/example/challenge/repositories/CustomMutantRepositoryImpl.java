package com.example.challenge.repositories;

import com.example.challenge.entities.MutantGene;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomMutantRepositoryImpl implements CustomMutantRepository{
    @Autowired
    MutantRepository mutantRepository;

    @Override
    public boolean deleteMutantById(Long id) {
        try {
            MutantGene gene = mutantRepository.getById(id);
            mutantRepository.deleteMutantById(gene.getId());
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
