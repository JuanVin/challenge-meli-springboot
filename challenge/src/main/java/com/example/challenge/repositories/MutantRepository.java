package com.example.challenge.repositories;

import com.example.challenge.entities.MutantGene;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MutantRepository extends JpaRepository<MutantGene, Long>, CustomMutantRepository {

}
