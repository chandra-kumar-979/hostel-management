package com.hms.HMSApplication.service;

import com.hms.HMSApplication.dto.BedUserDto;
import com.hms.HMSApplication.dto.enumlist.AdvanceStatus;
import com.hms.HMSApplication.entity.AdvanceDetails;
import com.hms.HMSApplication.entity.BedUser;
import com.hms.HMSApplication.exception.HMSException;
import com.hms.HMSApplication.repo.AdvanceDetailsRepository;
import com.hms.HMSApplication.repo.BedUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.hms.HMSApplication.utility.ErrorCodes.BU001;
import static com.hms.HMSApplication.utility.PasswordUtility.getPassword;
import static com.hms.HMSApplication.utility.SuccessCodes.PASS_SUCCESS;

@Service
public class BedUserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private BedUserRepository bedUserRepository;

    @Autowired
    private AdvanceDetailsRepository advanceDetailsRepository;

    public BedUserDto addBedUser(BedUserDto bedUserDto){
        Optional<BedUser> optionalBedUser = bedUserRepository.findByUserName(bedUserDto.getUserName());
        if(optionalBedUser.isEmpty()){
            BedUser bedUser = modelMapper.map(bedUserDto, BedUser.class);
            bedUser.setPassword(getPassword());
            return modelMapper.map(bedUserRepository.save(bedUser), BedUserDto.class);
        }else {
            return modelMapper.map(optionalBedUser.get(),BedUserDto.class);
        }
    }

    public String updateBedUserPassword(BedUserDto bedUserDto) throws HMSException{
        BedUser bedUser = bedUserRepository.findByUserName(bedUserDto.getUserName())
                .orElseThrow(() -> new HMSException(BU001));
        String password = passwordEncoder.encode(bedUser.getPassword());
        bedUser.setPassword(password);
        return PASS_SUCCESS;
    }

    public BedUserDto addAdvanceDetails(BedUserDto bedUserDto) throws HMSException{
        BedUser bedUser = bedUserRepository.findByUserName(bedUserDto.getUserName())
                .orElseThrow(()->new HMSException(BU001));
        AdvanceDetails advanceDetails;
        if(bedUser.getAdvanceDetails() == null){
            advanceDetails = advanceDetailsRepository
                    .save(modelMapper.map(bedUserDto.getAdvanceDetails(), AdvanceDetails.class));
        }else {
            advanceDetails = bedUser.getAdvanceDetails();
            advanceDetails.setAdvanceStatus(AdvanceStatus.ARCHIVE);
            advanceDetails = advanceDetailsRepository.save(advanceDetails);
        }
        bedUser.setAdvanceDetails(advanceDetails);
        return modelMapper.map(bedUserRepository.save(bedUser), BedUserDto.class);

    }

}
