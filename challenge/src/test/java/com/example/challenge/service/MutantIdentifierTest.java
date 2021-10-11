package com.example.challenge.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MutantIdentifierTest {

    private MutantIdentifier mutantIdentifier;
    private String[] dna;

    public MutantIdentifierTest() {
        this.mutantIdentifier = new MutantIdentifier();
        this.dna = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
    }

    @Test
    void isMutant() {
        assertTrue(mutantIdentifier.isMutant(dna));
    }

}