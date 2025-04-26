package com.hms.HMSApplication.service;

import com.hms.HMSApplication.dto.ProofSubmittedDto;
import com.hms.HMSApplication.entity.ProofSubmitted;
import com.hms.HMSApplication.exception.HMSException;
import com.hms.HMSApplication.repo.ProofSubmittedRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProofSubmittedService {

    @Autowired
    private ProofSubmittedRepository proofSubmittedRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProofSubmittedDto save(ProofSubmittedDto proofSubmittedDto) throws HMSException{
        return modelMapper.map(proofSubmittedRepository.save(modelMapper.map(proofSubmittedDto, ProofSubmitted.class)),
                ProofSubmittedDto.class);
    }
}
