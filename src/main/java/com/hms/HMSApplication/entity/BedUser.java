package com.hms.HMSApplication.entity;

import com.hms.HMSApplication.dto.enumlist.BedUserType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@Table(name = "bed_user")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bed_user_id", nullable = false)
    private UUID bedUserId;
    private String userName;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proof_submitted_id")
    private ProofSubmitted proofSubmitted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advance_details_id")
    private AdvanceDetails advanceDetails;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pay_receipt_id")
    private List<PayReceipt> payReceiptList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roles_id")
    private Roles roles;
    private LocalDateTime lastBillGeneration;
    private LocalDate rentPayDate;
    @Enumerated(EnumType.STRING)
    private BedUserType bedUserType;
    private Long pendingAmount;



}