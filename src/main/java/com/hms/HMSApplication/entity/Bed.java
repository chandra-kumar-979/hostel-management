package com.hms.HMSApplication.entity;

import com.hms.HMSApplication.dto.enumlist.BedStatus;
import com.hms.HMSApplication.dto.enumlist.BedType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@Table(name = "bed")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bed_id", nullable = false)
    private UUID bedId;
    private String bedName;
    @Enumerated(EnumType.STRING)
    private BedType bedType;
    @Enumerated(EnumType.STRING)
    private BedStatus bedStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bed_user_id")
    private BedUser bedUser;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bed_id")
    private List<ImageDetails> imageDetailsList;
    private Long amount;
    private Long perDayRent;

}