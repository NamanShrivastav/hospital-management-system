package com.hms.backend.service;

import com.hms.backend.dto.PatientRequestDTO;
import com.hms.backend.entity.Patient;
import java.util.List;

public interface PatientService {

    Patient createPatient(PatientRequestDTO dto);

    Patient getPatientById(Long id);

    List<Patient> getAllPatients();

    void deletePatient(Long id);
}
