package com.hms.backend.controller;

import com.hms.backend.dto.AppointmentRequestDTO;
import com.hms.backend.entity.Appointment;
import com.hms.backend.service.AppointmentService;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(
            @RequestBody AppointmentRequestDTO requestDTO) {

        return ResponseEntity.ok(
                appointmentService.createAppointment(requestDTO)
        );
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<Page<Appointment>> getAllAppointments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(
                appointmentService.getAllAppointments(page, size)
        );
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentById(id)
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable Long id,
            @RequestBody AppointmentRequestDTO requestDTO) {

        return ResponseEntity.ok(
                appointmentService.updateAppointment(id, requestDTO)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {

        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok("Appointment deleted successfully");
    }
}