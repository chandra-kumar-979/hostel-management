package com.hms.HMSApplication.repo;

import com.hms.HMSApplication.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FloorRepository extends JpaRepository<Floor, UUID> {
}