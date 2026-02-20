package com.hms.backend.billing.service;

import com.hms.backend.billing.entity.Bill;

public interface BillService {

    Bill generateBill(Long appointmentId, Double consultationFee, Double medicineCharge);

    Bill markAsPaid(Long billId);
}
