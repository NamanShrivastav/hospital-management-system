package com.hms.backend.service;

import com.hms.backend.dto.PatientRequestDTO;
import com.hms.backend.entity.Patient;

import java.util.List;

public interface PatientService {

    Patient createPatient(PatientRequestDTO dto);

    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    void deletePatient(Long id);
}
