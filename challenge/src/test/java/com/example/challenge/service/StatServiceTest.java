package com.example.challenge.service;

import com.example.challenge.entities.Stats;

import com.example.challenge.repositories.StatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

class StatServiceTest {

    @Mock
    private StatRepository statRepository;

    @InjectMocks
    private StatService statService;

    Stats stats;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        stats = Stats.builder()
                .id(1L)
                .count_human_dna(5)
                .count_mutant_dna(2)
                .build();
    }

    @Test
    void findOne() {

        when(statRepository.getById(any(Long.class))).thenReturn(stats);
        assertNotNull(statService.findOne(1L));
        assertEquals(statService.findOne(1L).getCount_human_dna(), 5);
        assertEquals(statService.findOne(1L).getCount_mutant_dna(), 2);
        assertEquals(statService.findOne(1L).getId(), 1L);

    }

    @Test
    void count() throws Exception {
        when(statRepository.count()).thenReturn(1L);
        assertNotNull(statService.count());
        assertEquals(statService.count(), 1L);
    }

    @Test
    void save() throws Exception {

        when(statRepository.save(stats)).thenReturn(stats);
        assertNotNull(statService.save(stats));
        assertEquals(statService.save(stats).getCount_mutant_dna(), 2);
        assertEquals(statService.save(stats).getId(), 1L);
        assertEquals(statService.save(stats).getCount_human_dna(), 5);

    }

    @Test
    void update() throws Exception {

        when(statRepository.getById(stats.getId())).thenReturn(stats);
        when(statRepository.save(stats)).thenReturn(stats);
        assertNotNull(statService.update(1L, stats));

    }

}