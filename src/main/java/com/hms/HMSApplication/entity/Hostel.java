package com.hms.HMSApplication.entity;

import com.hms.HMSApplication.dto.enumlist.HostelStatus;
import com.hms.HMSApplication.dto.enumlist.HostelType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Table(name = "hostel")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Hostel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hostel_id", nullable = false)
    private UUID hostelId;
    private String hostelName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
    @Enumerated(EnumType.STRING)
    private HostelStatus hostelStatus;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hostel_id")
    private List<Facilities> facilitiesList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hostel_id")
    private List<Floor> floorList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hostel_id")
    private List<ImageDetails> hostelImages;
    @Enumerated(EnumType.STRING)
    private HostelType hostelType;


}