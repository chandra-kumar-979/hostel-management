package com.hms.HMSApplication.service;

import com.hms.HMSApplication.dto.FacilitiesDto;
import com.hms.HMSApplication.entity.Facilities;
import com.hms.HMSApplication.repo.FacilitiesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityService {
    @Autowired
    private FacilitiesRepository facilityDAO;

    @Autowired
    private ModelMapper modelMapper;

    public FacilitiesDto addFacility(FacilitiesDto facilityDTO) {
        Facilities facility = modelMapper.map(facilityDTO, Facilities.class);
        Facilities savedFacility = facilityDAO.save(facility);
        return modelMapper.map(savedFacility, FacilitiesDto.class);
    }
}
