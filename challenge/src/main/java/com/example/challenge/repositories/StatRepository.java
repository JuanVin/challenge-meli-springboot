package com.example.challenge.repositories;

import com.example.challenge.entities.Stats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stats, Long>{

}
