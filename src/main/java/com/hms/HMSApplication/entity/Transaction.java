package com.hms.HMSApplication.entity;

import com.hms.HMSApplication.dto.enumlist.PaidStatus;
import com.hms.HMSApplication.dto.enumlist.TrasactionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@Table(name = "transaction")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id", nullable = false)
    private UUID transactionId;
    private LocalDateTime transactionDate;
    private Long transactionAmount;
    @Enumerated(EnumType.STRING)
    private PaidStatus paidStatus;
    @Enumerated(EnumType.STRING)
    private TrasactionStatus trasactionStatus;

}