package com.hms.backend.controller;

import com.hms.backend.dto.PatientRequestDTO;
import com.hms.backend.entity.Patient;
import com.hms.backend.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // CREATE PATIENT
    @PostMapping
    public ResponseEntity<Patient> createPatient(
            @Valid @RequestBody PatientRequestDTO dto) {

        Patient savedPatient = patientService.createPatient(dto);
        return ResponseEntity.ok(savedPatient);
    }

    // GET ALL PATIENTS
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    // GET PATIENT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    // DELETE PATIENT
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
