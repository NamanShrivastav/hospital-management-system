package com.hms.backend.billing.controller;

import com.hms.backend.billing.entity.Bill;
import com.hms.backend.billing.service.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/generate")
    public ResponseEntity<Bill> generateBill(
            @RequestParam Long appointmentId,
            @RequestParam Double consultationFee,
            @RequestParam Double medicineCharge) {

        return ResponseEntity.ok(
                billService.generateBill(appointmentId, consultationFee, medicineCharge)
        );
    }

    @PutMapping("/{billId}/pay")
    public ResponseEntity<Bill> markAsPaid(@PathVariable Long billId) {

        return ResponseEntity.ok(
                billService.markAsPaid(billId)
        );
    }
}
