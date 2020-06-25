package com.dit.himachal.modals;

import java.io.Serializable;

public class UsePoJo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1784569477847037016L;
	private Long user_id ;
	private String user_name;
	private Long mobile_number;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}
	@Override
	public String toString() {
		return "UsePoJo [user_id=" + user_id + ", user_name=" + user_name + ", mobile_number=" + mobile_number + "]";
	}
	
	

}
