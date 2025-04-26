package com.hms.HMSApplication.entity;

import com.hms.HMSApplication.dto.enumlist.AdvanceStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@Table(name = "advance_details")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AdvanceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "advance_details_id", nullable = false)
    private UUID advanceDetailsId;
    private Long advanceAmount;
    private LocalDateTime joiningDate;
    private LocalDateTime exitDate;
    @Enumerated(EnumType.STRING)
    private AdvanceStatus advanceStatus;


}