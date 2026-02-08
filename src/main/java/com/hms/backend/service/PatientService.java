package com.hms.backend.service;

import com.hms.backend.entity.Patient;

import java.util.List;

public interface PatientService {

    Patient createPatient(Patient patient);

    Patient getPatientById(Long id);

    List<Patient> getAllPatients();

    void deletePatient(Long id);
}
