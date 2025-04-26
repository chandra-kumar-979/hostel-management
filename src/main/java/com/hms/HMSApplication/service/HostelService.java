package com.hms.HMSApplication.service;

import com.hms.HMSApplication.dto.HostelDto;
import com.hms.HMSApplication.entity.Hostel;
import com.hms.HMSApplication.exception.HMSException;
import com.hms.HMSApplication.repo.HostelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostelService {

    @Autowired
    private HostelRepository hostelRepository;

    @Autowired
    private ModelMapper modelMapper;

    public HostelDto addHostel(HostelDto hostelDto) throws HMSException{
        Hostel hostelToBeAdd = modelMapper.map(hostelDto, Hostel.class);
        return modelMapper.map(hostelRepository.save(hostelToBeAdd), HostelDto.class);
    }
}
