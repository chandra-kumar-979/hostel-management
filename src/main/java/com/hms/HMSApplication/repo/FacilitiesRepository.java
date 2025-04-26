package com.hms.HMSApplication.repo;

import com.hms.HMSApplication.entity.Facilities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FacilitiesRepository extends JpaRepository<Facilities, UUID> {
}