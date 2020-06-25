package com.dit.himachal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dit.himachal.entities.BarrierMaster;
import com.dit.himachal.entities.OTPMaster;
import com.dit.himachal.entities.StatesMaster;
import com.dit.himachal.repositories.BarrierRepository;
import com.dit.himachal.repositories.OtpRepository;
import com.dit.himachal.repositories.StateRepository;

@Service
public class OtpService {
	
	@Autowired
	private OtpRepository otpRepository;

	public OtpRepository getOtpRepository() {
		return otpRepository;
	}

	public void setOtpRepository(OtpRepository otpRepository) {
		this.otpRepository = otpRepository;
	}
	
	
	public boolean isRecordExist(OTPMaster otp) { 
	   
	    Long count = (Long) otpRepository.getCountForOTP(otp.getMobilenumber());
	    return ( ( count.equals( 0L ) ) ? false : true );
	}

	
	
	
	public boolean saveOPT(OTPMaster otp) {
		
		OTPMaster master = otpRepository.save(otp);
		
		if(master.getId()!=null) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
public void updateOTPTable(OTPMaster otp) {
		otpRepository.updateOldOTPRecord(otp.getMobilenumber());
	}

public boolean VerifyOtp(Long mobile, Integer otp) {
	 Integer count =  otpRepository.verifyOtp(mobile, otp);
	    return ( ( count.equals( 0 ) ) ? false : true );
}


}
