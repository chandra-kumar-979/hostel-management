package com.hms.HMSApplication.repo;

import com.hms.HMSApplication.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolesRepository extends JpaRepository<Roles, UUID> {
}