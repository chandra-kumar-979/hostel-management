package com.hms.HMSApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@Table(name = "facilities")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Facilities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "facility_id", nullable = false)
    private UUID facilityId;
    private String facilityName;

}