package com.example.healthsystem.dto;

import com.example.healthsystem.entity.Medicine;
import com.example.healthsystem.entity.Patient;
import com.example.healthsystem.entity.Treatment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TreatmentDto {

    private String advice;

    private Long patientId;

    private Long medicineId;

    public Treatment toEntity() {
        return Treatment.builder()
                .advice(this.getAdvice())
                .patient(Patient.builder()
                        .id(this.getPatientId()).build())
                .medicine(Medicine.builder()
                        .id(this.getMedicineId()).build())
                .build();
    }

}
