package com.hms.HMSApplication.repo;

import com.hms.HMSApplication.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OwnerRepository extends JpaRepository<Owner, UUID> {
}