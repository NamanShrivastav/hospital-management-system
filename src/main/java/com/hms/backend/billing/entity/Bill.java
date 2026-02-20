package com.hms.backend.billing.entity;

import com.hms.backend.entity.Appointment;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double consultationFee;
    private Double medicineCharge;
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private BillStatus status;

    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;
}
