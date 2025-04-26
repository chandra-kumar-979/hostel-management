package com.hms.HMSApplication.dto;

import com.hms.HMSApplication.dto.enumlist.FloorType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.Floor} entity
 */
@Data
public class FloorDto implements Serializable {
    private final UUID floorId;
    private final String floorName;
    private final FloorType floorType;
    private final List<RoomDto> roomList;
    private final List<ImageDetailsDto> floorImages;
}