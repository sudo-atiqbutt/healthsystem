package com.example.healthsystem.controller;

import com.example.healthsystem.dto.TreatmentDto;
import com.example.healthsystem.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/treatments")
@RequiredArgsConstructor
public class TreatmentController {

    private final TreatmentService treatmentService;

    @PostMapping
    public ResponseEntity<TreatmentDto> createTreatment(@RequestBody TreatmentDto treatmentDto) {
       return ResponseEntity.status(HttpStatus.CREATED).body(treatmentService.createTreatment(treatmentDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentDto> getTreatmentById(@PathVariable Long id) {
        return ResponseEntity.ok(treatmentService.getTreatmentById(id));
    }
}

