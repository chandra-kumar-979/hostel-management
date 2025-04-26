package com.hms.HMSApplication.dto;

import com.hms.HMSApplication.dto.enumlist.OwnerStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.Owner} entity
 */
@Data
public class OwnerDto implements Serializable {
    private final UUID ownerId;
    private final String ownerName;
    private final AddressDto address;
    private final List<HostelDto> hostelList;
    private final OwnerStatus ownerStatus;
    private final String ownerUserName;
    private final String ownerPassword;
    private final RolesDto roles;
}