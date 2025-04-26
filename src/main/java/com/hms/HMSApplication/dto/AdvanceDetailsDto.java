package com.hms.HMSApplication.dto;

import com.hms.HMSApplication.dto.enumlist.AdvanceStatus;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.AdvanceDetails} entity
 */
@Data
public class AdvanceDetailsDto implements Serializable {
    private final UUID advanceDetailsId;
    private final Long advanceAmount;
    private final LocalDateTime joiningDate;
    private final LocalDateTime exitDate;
    private final AdvanceStatus advanceStatus;
}