package com.hms.HMSApplication.service;

import com.hms.HMSApplication.dto.TransactionDto;
import com.hms.HMSApplication.entity.Transaction;
import com.hms.HMSApplication.exception.HMSException;
import com.hms.HMSApplication.repo.TransactionRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TransactionDto save(TransactionDto transactionDto) throws HMSException{
        return modelMapper.map(transactionRepository.save(modelMapper.map(transactionDto, Transaction.class)),
                TransactionDto.class);
    }
}
