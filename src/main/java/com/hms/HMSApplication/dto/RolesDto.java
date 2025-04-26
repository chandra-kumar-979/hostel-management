package com.hms.HMSApplication.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.Roles} entity
 */
@Data
public class RolesDto implements Serializable {
    private final UUID id;
    private final String role;
}