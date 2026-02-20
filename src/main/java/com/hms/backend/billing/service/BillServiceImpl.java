package com.hms.backend.billing.service;

import com.hms.backend.billing.entity.Bill;
import com.hms.backend.billing.entity.BillStatus;
import com.hms.backend.billing.repository.BillRepository;
import com.hms.backend.entity.Appointment;
import com.hms.backend.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final AppointmentRepository appointmentRepository;

    public BillServiceImpl(BillRepository billRepository,
                           AppointmentRepository appointmentRepository) {
        this.billRepository = billRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Bill generateBill(Long appointmentId,
                             Double consultationFee,
                             Double medicineCharge) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        Double total = consultationFee + medicineCharge;

        Bill bill = Bill.builder()
                .appointment(appointment)
                .consultationFee(consultationFee)
                .medicineCharge(medicineCharge)
                .totalAmount(total)
                .status(BillStatus.UNPAID)
                .createdAt(LocalDateTime.now())
                .build();

        return billRepository.save(bill);
    }

    @Override
    public Bill markAsPaid(Long billId) {

        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        bill.setStatus(BillStatus.PAID);

        return billRepository.save(bill);
    }
}
