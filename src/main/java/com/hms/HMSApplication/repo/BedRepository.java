package com.hms.HMSApplication.repo;

import com.hms.HMSApplication.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BedRepository extends JpaRepository<Bed, UUID> {
}