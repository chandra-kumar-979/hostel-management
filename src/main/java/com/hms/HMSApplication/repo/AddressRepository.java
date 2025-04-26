package com.hms.HMSApplication.repo;

import com.hms.HMSApplication.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}