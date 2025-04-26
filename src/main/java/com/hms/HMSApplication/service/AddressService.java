package com.hms.HMSApplication.service;

import com.hms.HMSApplication.dto.AddressDto;
import com.hms.HMSApplication.entity.Address;
import com.hms.HMSApplication.exception.HMSException;
import com.hms.HMSApplication.repo.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressRepository addressRepository;

    public AddressDto addNewAddress(AddressDto addressDto) throws HMSException {
        Address address = modelMapper.map(addressDto, Address.class);
        Address savedAddress = addressRepository.save(address);
        return modelMapper.map(savedAddress, AddressDto.class);
    }
}
