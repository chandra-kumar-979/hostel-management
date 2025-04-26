package com.hms.HMSApplication.dto;

import com.hms.HMSApplication.dto.enumlist.HostelStatus;
import com.hms.HMSApplication.dto.enumlist.HostelType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.Hostel} entity
 */
@Data
public class HostelDto implements Serializable {
    private final UUID hostelId;
    private final String hostelName;
    private final AddressDto address;
    private final HostelStatus hostelStatus;
    private final List<FacilitiesDto> facilitiesList;
    private final List<FloorDto> floorList;
    private final List<ImageDetailsDto> hostelImages;
    private final HostelType hostelType;
}