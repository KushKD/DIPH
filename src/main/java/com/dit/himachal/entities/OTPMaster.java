package com.dit.himachal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="otp_login")
public class OTPMaster {
	
	 	@Id
	    @GeneratedValue(generator = "otp_login_id_seq", strategy = GenerationType.AUTO)
	    @SequenceGenerator(name = "otp_login_id_seq", sequenceName = "public.otp_login_id_seq", initialValue = 1, allocationSize = 1)
	    @Column(name="id")
	    private Long id;
	 
	 	@Column(name = "mobile_number")
	    private Long mobilenumber;

	    @Column(name = "otp")
	    private Integer otp;
	    
	    @Column(name = "active")
	    private boolean active;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getMobilenumber() {
			return mobilenumber;
		}

		public void setMobilenumber(Long mobilenumber) {
			this.mobilenumber = mobilenumber;
		}

		public Integer getOtp() {
			return otp;
		}

		public void setOtp(Integer otp) {
			this.otp = otp;
		}

		

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		@Override
		public String toString() {
			return "OTPMaster [id=" + id + ", mobilenumber=" + mobilenumber + ", otp=" + otp + ", active="
					+ active + "]";
		}
	    
	    
	 
	 
	 

}
