package com.hms.backend.service.impl;

import com.hms.backend.dto.PatientRequestDTO;
import com.hms.backend.entity.Patient;
import com.hms.backend.repository.PatientRepository;
import com.hms.backend.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient createPatient(PatientRequestDTO dto) {

        Patient patient = new Patient();
        patient.setFullName(dto.getFullName());
        patient.setPhone(dto.getPhone());
        patient.setAddress(dto.getAddress());
        patient.setGender(dto.getGender());
        patient.setDateOfBirth(dto.getDateOfBirth());

        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
