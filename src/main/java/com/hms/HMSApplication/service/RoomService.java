package com.hms.HMSApplication.service;

import com.hms.HMSApplication.dto.RoomDto;
import com.hms.HMSApplication.entity.Bed;
import com.hms.HMSApplication.entity.Room;
import com.hms.HMSApplication.exception.HMSException;
import com.hms.HMSApplication.repo.BedRepository;
import com.hms.HMSApplication.repo.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hms.HMSApplication.utility.ErrorCodes.R001;

@Service
public class RoomService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BedRepository bedRepository;

    public RoomDto addRoom(RoomDto roomDto) throws HMSException{
        return modelMapper.map(roomRepository.save(modelMapper.map(roomDto, Room.class)), RoomDto.class);
    }

    public RoomDto updateBedDetailsToRoom(RoomDto roomDto) throws HMSException{
        Room room = roomRepository.findById(roomDto.getRoomId()).orElseThrow(() -> new HMSException(R001));
        List<Bed> bedList = roomDto.getBedList().stream().map(bed -> modelMapper.map(bed, Bed.class)).toList();
        bedList = bedRepository.saveAll(bedList);
        room.setBedList(bedList);
        return modelMapper.map(roomRepository.save(room), RoomDto.class);
    }
}
