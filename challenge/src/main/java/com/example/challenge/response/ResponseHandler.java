package com.example.challenge.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(double count_mutant_dna, double count_human_dna, Double ratio, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("count_mutant_dna", count_mutant_dna);
        map.put("count_human_dna", count_human_dna);
        map.put("ratio", ratio);
        map.put("status", status.value());
        return new ResponseEntity<Object>(map,status);
    }
}
