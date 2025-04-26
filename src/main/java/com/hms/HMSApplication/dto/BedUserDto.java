package com.hms.HMSApplication.dto;

import com.hms.HMSApplication.dto.enumlist.BedUserType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.BedUser} entity
 */
@Data
public class BedUserDto implements Serializable {
    private final UUID bedUserId;
    private final String userName;
    private final String password;
    private final AddressDto address;
    private final ProofSubmittedDto proofSubmitted;
    private final AdvanceDetailsDto advanceDetails;
    private final List<PayReceiptDto> payReceiptList;
    private final RolesDto roles;
    private final LocalDateTime lastBillGeneration;
    private final LocalDate rentPayDate;
    private final BedUserType bedUserType;
    private final Long pendingAmount;
}