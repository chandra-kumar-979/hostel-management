package com.hms.HMSApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id", nullable = false)
    private UUID addressId;
    private String locationName;
    private String nearLandmark;
    private String distinct;
    private String state;
    private Long pincode;
    private String phoneNumber;
    private String emailId;

}