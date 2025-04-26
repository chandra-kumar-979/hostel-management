package com.hms.HMSApplication.dto;

import com.hms.HMSApplication.dto.enumlist.RoomStatus;
import com.hms.HMSApplication.dto.enumlist.RoomType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.Room} entity
 */
@Data
public class RoomDto implements Serializable {
    private final UUID roomId;
    private final String roomName;
    private final RoomType roomType;
    private final List<BedDto> bedList;
    private final RoomStatus roomStatus;
}