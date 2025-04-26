package com.hms.HMSApplication.entity;

import com.hms.HMSApplication.dto.enumlist.FloorType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Table(name = "floor")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "floor_id", nullable = false)
    private UUID floorId;
    private String floorName;
    private FloorType floorType;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "floor_id")
    private List<Room> roomList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "floor_id")
    private List<ImageDetails> floorImages;

}