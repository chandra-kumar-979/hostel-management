package com.hms.HMSApplication.service;

import com.hms.HMSApplication.dto.AdvanceDetailsDto;
import com.hms.HMSApplication.entity.AdvanceDetails;
import com.hms.HMSApplication.exception.HMSException;
import com.hms.HMSApplication.repo.AdvanceDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvanceDetailsService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AdvanceDetailsRepository advanceDetailsRepository;

    public AdvanceDetailsDto addAdvanceDetails(AdvanceDetailsDto advanceDetailsDto) throws HMSException {
        AdvanceDetails advanceDetails = modelMapper.map(advanceDetailsDto, AdvanceDetails.class);
        AdvanceDetails savedAdvanceDetails = advanceDetailsRepository.save(advanceDetails);
        return modelMapper.map(savedAdvanceDetails,AdvanceDetailsDto.class);
    }
}
