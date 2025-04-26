package com.hms.HMSApplication.entity;

import com.hms.HMSApplication.dto.enumlist.RoomStatus;
import com.hms.HMSApplication.dto.enumlist.RoomType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@Table(name = "room")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id", nullable = false)
    private UUID roomId;
    private String roomName;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "room_id")
    private List<Bed> bedList;
    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

}