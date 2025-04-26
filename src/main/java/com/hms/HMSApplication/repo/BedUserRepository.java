package com.hms.HMSApplication.repo;

import com.hms.HMSApplication.entity.BedUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BedUserRepository extends JpaRepository<BedUser, UUID> {
    Optional<BedUser> findByUserName(String userName);
}