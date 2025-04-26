package com.hms.HMSApplication.repo;

import com.hms.HMSApplication.entity.PayReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PayReceiptRepository extends JpaRepository<PayReceipt, UUID> {
}
