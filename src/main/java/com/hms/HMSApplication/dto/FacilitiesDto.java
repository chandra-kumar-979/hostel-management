package com.hms.HMSApplication.dto;

import com.hms.HMSApplication.entity.Facilities;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link Facilities} entity
 */
@Data
public class FacilitiesDto implements Serializable {
    private final UUID facilityId;
    private final String facilityName;
}