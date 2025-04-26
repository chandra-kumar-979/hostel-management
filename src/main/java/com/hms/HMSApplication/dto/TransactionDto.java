package com.hms.HMSApplication.dto;

import com.hms.HMSApplication.dto.enumlist.PaidStatus;
import com.hms.HMSApplication.dto.enumlist.TrasactionStatus;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.Transaction} entity
 */
@Data
public class TransactionDto implements Serializable {
    private final UUID transactionId;
    private final LocalDateTime transactionDate;
    private final Long transactionAmount;
    private final PaidStatus paidStatus;
    private final TrasactionStatus trasactionStatus;
}