package com.hms.HMSApplication.repo;

import com.hms.HMSApplication.entity.AdvanceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdvanceDetailsRepository extends JpaRepository<AdvanceDetails, UUID> {
}