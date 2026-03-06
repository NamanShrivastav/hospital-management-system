package com.hms.backend.service;

import com.hms.backend.dto.AppointmentRequestDTO;
import com.hms.backend.entity.Appointment;
import com.hms.backend.entity.Doctor;
import com.hms.backend.entity.Patient;
import com.hms.backend.exception.ResourceNotFoundException;
import com.hms.backend.repository.AppointmentRepository;
import com.hms.backend.repository.DoctorRepository;
import com.hms.backend.repository.PatientRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              PatientRepository patientRepository) {

        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    // CREATE
    public Appointment createAppointment(AppointmentRequestDTO request) {

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        Appointment appointment = new Appointment();

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentTime(request.getAppointmentTime());
        appointment.setStatus(request.getStatus());

        return appointmentRepository.save(appointment);
    }

    // GET ALL (pagination)
    public Page<Appointment> getAllAppointments(int page, int size) {
        return appointmentRepository.findAll(PageRequest.of(page, size));
    }

    // GET BY ID
    public Appointment getAppointmentById(Long id) {

        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));
    }

    // UPDATE
    public Appointment updateAppointment(Long id, AppointmentRequestDTO request) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentTime(request.getAppointmentTime());
        appointment.setStatus(request.getStatus());

        return appointmentRepository.save(appointment);
    }

    // DELETE
    public void deleteAppointment(Long id) {

        if (!appointmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Appointment not found");
        }

        appointmentRepository.deleteById(id);
    }
}