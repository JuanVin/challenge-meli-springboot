package com.example.challenge.controller;

import com.example.challenge.entities.MutantGene;
import com.example.challenge.entities.Stats;
import com.example.challenge.response.ResponseHandler;
import com.example.challenge.service.MutantService;
import com.example.challenge.service.MutantIdentifier;
import com.example.challenge.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/home")

public class MutantController {

    @Autowired
    private MutantIdentifier mutantIdentifier;

    @Autowired
    private MutantService mutantService;

    @Autowired
    private StatService statService;

    @PostMapping("/mutant")
    public ResponseEntity<?> isMutant(@RequestBody MutantGene gen){
        try{
            Stats stats;
            if (statService.count() == 0){
                stats = new Stats();
                stats.setCount_mutant_dna(0);
                stats.setCount_human_dna(0);
                statService.save(stats);
            }else{stats = statService.findOne(1L);}

            if (mutantIdentifier.isMutant(gen.getDna())){
                gen.setMutant(true);
                mutantService.save(gen);
                stats.setCount_mutant_dna(stats.getCount_mutant_dna()+1);
                statService.update(1L, stats);
                return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"Nuevo mutante hallado.\"}");
            }
            else {
                gen.setMutant(false);
                mutantService.save(gen);
                stats.setCount_human_dna(stats.getCount_human_dna()+1);
                statService.update(1L, stats);
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Mensaje\":\"No tiene gen mutante.\"}");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/stats")
    public ResponseEntity<?> getAll(){
        try {
            Stats stats = statService.findOne(1L);
            double count_mutant_dna = stats.getCount_mutant_dna(),
                    count_human_dna = stats.getCount_human_dna();

            double ratio = count_mutant_dna/count_human_dna;


            return ResponseHandler.generateResponse(count_mutant_dna,count_human_dna,ratio,HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

}
