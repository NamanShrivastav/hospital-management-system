package com.hms.backend.billing.repository;

import com.hms.backend.billing.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
