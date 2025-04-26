package com.hms.HMSApplication.dto;

import com.hms.HMSApplication.dto.enumlist.BedStatus;
import com.hms.HMSApplication.dto.enumlist.BedType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.Bed} entity
 */
@Data
public class BedDto implements Serializable {
    private final UUID bedId;
    private final String bedName;
    private final BedType bedType;
    private final BedStatus bedStatus;
    private final BedUserDto bedUser;
    private final List<ImageDetailsDto> imageDetailsList;
    private final Long amount;
    private final Long perDayRent;
}