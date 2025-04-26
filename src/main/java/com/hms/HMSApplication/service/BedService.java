package com.hms.HMSApplication.service;

import com.hms.HMSApplication.dto.BedDto;
import com.hms.HMSApplication.dto.BedUserDto;
import com.hms.HMSApplication.dto.enumlist.BedStatus;
import com.hms.HMSApplication.dto.enumlist.BedUserType;
import com.hms.HMSApplication.dto.enumlist.PaymentStatus;
import com.hms.HMSApplication.entity.Bed;
import com.hms.HMSApplication.entity.BedUser;
import com.hms.HMSApplication.entity.PayReceipt;
import com.hms.HMSApplication.exception.HMSException;
import com.hms.HMSApplication.repo.BedRepository;
import com.hms.HMSApplication.repo.BedUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.hms.HMSApplication.utility.Constants.NEW_LINE;
import static com.hms.HMSApplication.utility.ErrorCodes.*;

@Service
public class BedService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BedRepository bedRepository;
    @Autowired
    private BedUserService bedUserService;

    @Autowired
    private BedUserRepository bedUserRepository;

    public BedDto addBed(BedDto bedDto) throws HMSException{
        Bed bed = modelMapper.map(bedDto, Bed.class);
        Bed savedBed = bedRepository.save(bed);
        return modelMapper.map(savedBed,BedDto.class);
    }

    public void deleteBed(BedDto bedDto) throws HMSException{
        bedRepository.findById(bedDto.getBedId()).orElseThrow(() -> new HMSException(B001));
        Bed bed = modelMapper.map(bedDto, Bed.class);
        bed.setBedUser(null);
        bed.setImageDetailsList(null);
        bedRepository.delete(bed);
    }

    public BedDto addBedUserToBed(BedDto bedDto,BedUserDto bedUserDto) throws HMSException{
        //check bed exist
        Bed bed = bedRepository.findById(bedDto.getBedId()).orElseThrow(() -> new HMSException(B001));
        //check user exist if not add a new user
        BedUserDto addedBedUser = bedUserService.addBedUser(bedUserDto);

        if(bed.getBedStatus().equals(BedStatus.OCCUPIED))
            throw new HMSException(B003);
        else if(bed.getBedStatus().equals(BedStatus.SUSPENDED))
            throw new HMSException(B002);
        else{
            BedUser bedUser = modelMapper.map(addedBedUser, BedUser.class);
            bed.setBedUser(bedUser);
            bed.setBedStatus(BedStatus.OCCUPIED);
            bedDto = modelMapper.map(bedRepository.save(bed), BedDto.class);
        }
        return bedDto;
    }

    public BedDto makeBedAvailable(BedDto bedDto) throws HMSException{
        Bed bed = bedRepository.findById(bedDto.getBedId()).orElseThrow(() -> new HMSException(B001));
        if(bed.getBedStatus().equals(BedStatus.OCCUPIED)){
            //Need to verify bed user details before release
            validateBedUserBeforeRelease(bed);
            bed.setBedUser(null);
            bed.setBedStatus(BedStatus.AVAILABLE);
            bedDto = modelMapper.map(bedRepository.save(bed),BedDto.class);
            return bedDto;
        }else {
            throw new HMSException(B004);
        }
    }

    private void validateBedUserBeforeRelease(Bed bed) throws HMSException {
        BedUser bedUser = bed.getBedUser();
        LocalDateTime lastBillGeneration = bedUser.getLastBillGeneration();
        LocalDateTime joiningDate = bedUser.getAdvanceDetails().getJoiningDate();
        if(bedUser.getBedUserType().equals(BedUserType.DINER)){
            Long perDayRent = bed.getPerDayRent();
            Long numberOfDays = Duration.between(lastBillGeneration, joiningDate).toDays();
            Long payableAmount = perDayRent*numberOfDays;
            if(bedUser.getPayReceiptList().isEmpty())
                throw new HMSException(BU004);
            Long amountPaid = 0L;
            for(PayReceipt payReceipt : bedUser.getPayReceiptList()){
                amountPaid += payReceipt.getAmountPaid();
            }

            if(!amountPaid.equals(payableAmount))
                throw new HMSException(BU003 + "of" + bedUser.getPendingAmount());

        }else {
            List<String> pendingMonths = getPendingMessages(bedUser);

            if(!pendingMonths.isEmpty()){
                throw new HMSException(BU003 + NEW_LINE + String.join(NEW_LINE, pendingMonths));
            }

        }

    }

    private static List<String> getPendingMessages(BedUser bedUser) {
        List<PayReceipt> payReceiptList = bedUser.getPayReceiptList();
        List<String> pendingMonths = new ArrayList<>();

        for(PayReceipt payReceipt :payReceiptList) {
            if(payReceipt.getPaymentStatus().equals(PaymentStatus.PENDING)){

                String message = payReceipt.getReceiptGenerationDate().getMonth().name()
                        + "/" + payReceipt.getReceiptGenerationDate().getYear()
                        + " : " + payReceipt.getAmountPaid() + " : "
                        + payReceipt.getPaymentStatus()
                        + NEW_LINE;
                pendingMonths.add(message);
            }
        }
        return pendingMonths;
    }

    public BedDto suspendBed(BedDto bedDto) throws HMSException{
         Bed bed = bedRepository.findById(bedDto.getBedId()).orElseThrow(() -> new HMSException(B001));
         bed.setBedUser(null);
         bed.setBedStatus(BedStatus.SUSPENDED);
         bedDto = modelMapper.map(bedRepository.save(bed),BedDto.class);
         return bedDto;
     }

}
