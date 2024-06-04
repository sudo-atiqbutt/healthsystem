package com.example.healthsystem.service;

import com.example.healthsystem.entity.Treatment;
import com.example.healthsystem.repository.MedicineRepository;
import com.example.healthsystem.repository.PatientRepository;
import com.example.healthsystem.repository.TreatmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;

@Service
@Slf4j
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    public ResponseEntity<Treatment> createTreatment(final Treatment treatment) {
        if (Objects.isNull(treatment.getPatient()) || Objects.isNull(treatment.getMedicine())) {
            throw new IllegalArgumentException("Patient and Medicine must not be null");
        }

        if (!patientRepository.existsById(treatment.getPatient().getId())) {
            throw new EntityNotFoundException("Patient not found");
        }

        if (!medicineRepository.existsById(treatment.getMedicine().getId())) {
            throw new EntityNotFoundException("Medicine not found");
        }

        Treatment savedTreatment = treatmentRepository.save(treatment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTreatment);
    }

    public ResponseEntity<Treatment> getTreatmentById(final Long id) {
        return ResponseEntity.ok(treatmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Treatment not found")));
    }


}
