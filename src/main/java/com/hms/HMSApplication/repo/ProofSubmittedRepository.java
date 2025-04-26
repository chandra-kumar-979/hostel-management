package com.hms.HMSApplication.repo;

import com.hms.HMSApplication.entity.ProofSubmitted;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProofSubmittedRepository extends JpaRepository<ProofSubmitted, UUID> {
}