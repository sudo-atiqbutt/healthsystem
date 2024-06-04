package com.example.healthsystem.controller;

import com.example.healthsystem.dto.TreatmentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TreatmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateTreatment() throws Exception {
        TreatmentDto treatment = new TreatmentDto();
        treatment.setAdvice("Take twice daily");
        treatment.setPatientId(1L);
        treatment.setMedicineId(1L);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/treatments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(treatment)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.advice").value("Take twice daily"));
    }

    @Test
    public void testGetTreatmentById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/treatments/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.advice").value("Take twice daily"));
    }
}

