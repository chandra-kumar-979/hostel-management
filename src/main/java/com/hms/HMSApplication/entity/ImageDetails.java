package com.hms.HMSApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "image_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_details_id", nullable = false)
    private UUID imageDetailsId;
    private String imagePath;
    private String imageType;

}