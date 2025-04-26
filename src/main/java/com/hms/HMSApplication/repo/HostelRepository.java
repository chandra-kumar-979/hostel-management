package com.hms.HMSApplication.repo;

import com.hms.HMSApplication.entity.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HostelRepository extends JpaRepository<Hostel, UUID> {
}