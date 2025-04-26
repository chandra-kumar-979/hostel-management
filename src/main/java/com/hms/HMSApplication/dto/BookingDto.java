package com.hms.HMSApplication.dto;

import com.hms.HMSApplication.dto.enumlist.BookingStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.Booking} entity
 */
@Data
public class BookingDto implements Serializable {
    private final UUID bookingId;
    private final HostelDto hostel;
    private final BedDto bed;
    private final RoomDto room;
    private final BedUserDto bedUser;
    private final OwnerDto owner;
    private final BookingStatus bookingStatus;
    private final TransactionDto transaction;
}