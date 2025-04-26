package com.hms.HMSApplication.service;

import com.hms.HMSApplication.dto.FloorDto;
import com.hms.HMSApplication.entity.Floor;
import com.hms.HMSApplication.exception.HMSException;
import com.hms.HMSApplication.repo.FloorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorService {

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public FloorDto addFloor(FloorDto floorDto) throws HMSException{
        Floor floorTobeAdd = modelMapper.map(floorDto, Floor.class);
        return modelMapper.map(floorRepository.save(floorTobeAdd), FloorDto.class);
    }
}
