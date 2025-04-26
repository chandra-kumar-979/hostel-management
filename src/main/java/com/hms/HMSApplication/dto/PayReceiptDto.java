package com.hms.HMSApplication.dto;

import com.hms.HMSApplication.dto.enumlist.PayReceiptType;
import com.hms.HMSApplication.dto.enumlist.PaymentStatus;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.PayReceipt} entity
 */
@Data
public class PayReceiptDto implements Serializable {
    private final UUID payReceiptId;
    private final LocalDateTime receiptGenerationDate;
    private final PayReceiptType payReceiptType;
    private final Long amountPaid;
    private final String payReceiptDescription;
    private final PaymentStatus paymentStatus;
}