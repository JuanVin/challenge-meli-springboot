package com.example.challenge.service;

import com.example.challenge.entities.MutantGene;
import com.example.challenge.repositories.MutantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MutantServiceTest {

    @Mock
    MutantRepository mutantRepository;

    @InjectMocks
    MutantService mutantService;

    MutantGene mutantGene;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mutantGene = MutantGene.builder()
                .id(1L)
                .dna(new String[]{"asd","asd"})
                .isMutant(true)
                .build();
    }

    @Test
    void findAll() {
        when(mutantRepository.findAll()).thenReturn(Arrays.asList(mutantGene));
        assertNotNull(mutantService.findAll());
    }

    @Test
    void save() {
        when(mutantRepository.save(mutantGene)).thenReturn(mutantGene);
        assertNotNull(mutantService.save(mutantGene));
        assertEquals(mutantService.save(mutantGene), mutantGene);
    }

    @Test
    void deleteMutantById() {
        when(mutantRepository.deleteMutantById(1L)).thenReturn(true);
        assertTrue(mutantService.deleteMutantById(1L));
    }

}