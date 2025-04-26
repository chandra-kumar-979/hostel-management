package com.hms.HMSApplication.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.Address} entity
 */
@Data
public class AddressDto implements Serializable {
    private final UUID addressId;
    private final String locationName;
    private final String nearLandmark;
    private final String distinct;
    private final String state;
    private final Long pincode;
    private final String phoneNumber;
    private final String emailId;
}