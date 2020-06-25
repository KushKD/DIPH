package com.dit.himachal.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dit.himachal.entities.OTPMaster;

@Repository
public interface OtpRepository extends CrudRepository<OTPMaster, Long> {

	
	 @Query(value="SELECT count(*) FROM public.otp_login WHERE  mobile_number =:mobile AND active = true ", nativeQuery = true)
	 Long getCountForOTP(@Param("mobile") Long mobile);
	 
	 @Modifying(clearAutomatically = true)
	 @Query(value="UPDATE public.otp_login SET active = false WHERE mobile_number = :mobile", nativeQuery = true)
	 void updateOldOTPRecord(@Param("mobile") Long mobile);
	 
	 @Query(value="SELECT count(*) FROM public.otp_login WHERE  mobile_number =:mobile AND active = true AND otp =:otpNumber", nativeQuery = true)
	 Integer verifyOtp(@Param("mobile") Long mobile , @Param("otpNumber") Integer otpNumber);
	 
}


