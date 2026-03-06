package com.hms.backend.mapper;

import com.hms.backend.dto.AppointmentRequestDTO;
import com.hms.backend.dto.AppointmentResponseDTO;
import com.hms.backend.entity.Appointment;

public class AppointmentMapper {

    // Convert Entity → ResponseDTO
    public static AppointmentResponseDTO toResponseDTO(Appointment appointment) {

        AppointmentResponseDTO dto = new AppointmentResponseDTO();

        dto.setId(appointment.getId());
        dto.setDoctorId(appointment.getDoctor().getId());
        dto.setPatientId(appointment.getPatient().getId());
        dto.setAppointmentTime(appointment.getAppointmentTime());
        dto.setStatus(appointment.getStatus());

        return dto;
    }

}