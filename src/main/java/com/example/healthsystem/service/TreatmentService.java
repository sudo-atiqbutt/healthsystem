package com.example.healthsystem.service;

import com.example.healthsystem.dto.TreatmentDto;
import com.example.healthsystem.entity.Treatment;
import com.example.healthsystem.repository.MedicineRepository;
import com.example.healthsystem.repository.PatientRepository;
import com.example.healthsystem.repository.TreatmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;

    private final PatientRepository patientRepository;

    private final MedicineRepository medicineRepository;

    public TreatmentDto createTreatment(final TreatmentDto treatment) {
        if (Objects.isNull(treatment.getPatientId()) || Objects.isNull(treatment.getMedicineId())) {
            throw new IllegalArgumentException("Patient and Medicine must not be null");
        }

        if (!patientRepository.existsById(treatment.getPatientId())) {
            throw new EntityNotFoundException("Patient not found");
        }

        if (!medicineRepository.existsById(treatment.getMedicineId())) {
            throw new EntityNotFoundException("Medicine not found");
        }

        Treatment savedTreatment = treatmentRepository.save(treatment.toEntity());
        return savedTreatment.toDto();
    }

    public TreatmentDto getTreatmentById(final Long id) {
        return treatmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Treatment not found")).toDto();
    }


}
