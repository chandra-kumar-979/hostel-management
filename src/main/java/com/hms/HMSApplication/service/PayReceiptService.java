package com.hms.HMSApplication.service;

import com.hms.HMSApplication.dto.PayReceiptDto;
import com.hms.HMSApplication.entity.PayReceipt;
import com.hms.HMSApplication.exception.HMSException;
import com.hms.HMSApplication.repo.PayReceiptRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayReceiptService {

    @Autowired
    private PayReceiptRepository payReceiptRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PayReceiptDto save(PayReceiptDto payReceiptDto) throws HMSException{
        return modelMapper.map(payReceiptRepository.save(modelMapper.map(payReceiptDto, PayReceipt.class)),
                PayReceiptDto.class);
    }

}
