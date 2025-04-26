package com.hms.HMSApplication.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.ImageDetails} entity
 */
@Data
public class ImageDetailsDto implements Serializable {
    private final UUID imageDetailsId;
    private final String imagePath;
    private final String imageType;
}