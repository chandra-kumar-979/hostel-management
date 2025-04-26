package com.hms.HMSApplication.entity;

import com.hms.HMSApplication.dto.enumlist.PayReceiptType;
import com.hms.HMSApplication.dto.enumlist.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@Table(name = "pay_receipt")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PayReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pay_receipt_id", nullable = false)
    private UUID payReceiptId;
    private LocalDateTime receiptGenerationDate;
    @Enumerated(EnumType.STRING)
    private PayReceiptType payReceiptType;
    private Long amountPaid;
    private String payReceiptDescription;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

}