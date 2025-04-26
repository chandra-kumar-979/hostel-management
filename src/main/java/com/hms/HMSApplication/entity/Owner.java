package com.hms.HMSApplication.entity;

import com.hms.HMSApplication.dto.enumlist.OwnerStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Table(name = "owner")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "owner_id", nullable = false)
    private UUID ownerId;
    private String ownerName;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "owner_id")
    private List<Hostel> hostelList;
    @Enumerated(EnumType.STRING)
    private OwnerStatus ownerStatus;
    private String ownerUserName;
    private String ownerPassword;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roles_id")
    private Roles roles;


}