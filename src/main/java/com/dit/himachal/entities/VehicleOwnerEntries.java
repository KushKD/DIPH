package com.dit.himachal.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "mst_vehicle_owner_entries")
public class VehicleOwnerEntries implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7537163873024423738L;
	
	@Id
	@GeneratedValue(generator = "mst_vehicle_owner_type_vehicle_owner_type_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "mst_vehicle_owner_type_vehicle_owner_type_id_seq", sequenceName = "public.mst_vehicle_owner_type_vehicle_owner_type_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "vehicle_owner_id")
	private Long vehicleOwnerId;
	
	@Column(name = "id_card_number")
	private String idCardNumber;
	
	@Column(name = "district_id")
	private int vehicleDistrictId;
	
	@Column(name = "barrier_id")
	private int vehicleBarrierId;
	
	@Column(name = "vehicle_type_id")
	private int vehicleTypeId;

	@Column(name = "vehicle_owner_type_id")
	private int vehicleOwnerTypeId;
	
	@Column(name = "vehicle_owner_name")
	private String vehicleOwnerName;
	
	@Column(name = "vehicle_owner_imagename")
	private String vehicleOwnerImageName;
	
	@Column(name = "vehicle_owner_mobile_number")
	private int vehicleOwnerMobileNumber;
	
	@Column(name = "id_valid_from")
	private Date isValidFrom;
	
	@Column(name = "id_valid_upto")
	private Date isValidUpto;
	
	@Column(name = "vehicle_owner_aadhaar_number")
	private String vehicleOwnerAadhaarNumber;

	@Column(name = "vehicle_owner_vehicle_number")
	private String vehicleOwnerVehicleNumber;
	
	@Column(name = "vehicle_owner_chassis_number")
	private String vehicleOwnerChassisNumber;
	
	@Column(name = "vehicle_owner_engine_number")
	private String vehicleOwnerEngineNumber;
	
	@Column(name = "vehicle_owner_driving_licence")
	private String vehicleOwnerDrivingLicence;
	
	@Column(name = "mobile_information")
	private String mobileInformation;
	
	@Column(name = "other_information")
	private String otherInformation;
	
	@Column(name = "data_entered_by")
	private int dataEnteredBy;
	
	@Column(name = "active")
	private boolean active;

	public Long getVehicleOwnerId() {
		return vehicleOwnerId;
	}

	public void setVehicleOwnerId(Long vehicleOwnerId) {
		this.vehicleOwnerId = vehicleOwnerId;
	}

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public int getVehicleDistrictId() {
		return vehicleDistrictId;
	}

	public void setVehicleDistrictId(int vehicleDistrictId) {
		this.vehicleDistrictId = vehicleDistrictId;
	}

	public int getVehicleBarrierId() {
		return vehicleBarrierId;
	}

	public void setVehicleBarrierId(int vehicleBarrierId) {
		this.vehicleBarrierId = vehicleBarrierId;
	}

	public int getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public int getVehicleOwnerTypeId() {
		return vehicleOwnerTypeId;
	}

	public void setVehicleOwnerTypeId(int vehicleOwnerTypeId) {
		this.vehicleOwnerTypeId = vehicleOwnerTypeId;
	}

	public String getVehicleOwnerName() {
		return vehicleOwnerName;
	}

	public void setVehicleOwnerName(String vehicleOwnerName) {
		this.vehicleOwnerName = vehicleOwnerName;
	}

	public String getVehicleOwnerImageName() {
		return vehicleOwnerImageName;
	}

	public void setVehicleOwnerImageName(String vehicleOwnerImageName) {
		this.vehicleOwnerImageName = vehicleOwnerImageName;
	}

	public int getVehicleOwnerMobileNumber() {
		return vehicleOwnerMobileNumber;
	}

	public void setVehicleOwnerMobileNumber(int vehicleOwnerMobileNumber) {
		this.vehicleOwnerMobileNumber = vehicleOwnerMobileNumber;
	}

	public Date getIsValidFrom() {
		return isValidFrom;
	}

	public void setIsValidFrom(Date isValidFrom) {
		this.isValidFrom = isValidFrom;
	}

	public Date getIsValidUpto() {
		return isValidUpto;
	}

	public void setIsValidUpto(Date isValidUpto) {
		this.isValidUpto = isValidUpto;
	}

	public String getVehicleOwnerAadhaarNumber() {
		return vehicleOwnerAadhaarNumber;
	}

	public void setVehicleOwnerAadhaarNumber(String vehicleOwnerAadhaarNumber) {
		this.vehicleOwnerAadhaarNumber = vehicleOwnerAadhaarNumber;
	}

	public String getVehicleOwnerVehicleNumber() {
		return vehicleOwnerVehicleNumber;
	}

	public void setVehicleOwnerVehicleNumber(String vehicleOwnerVehicleNumber) {
		this.vehicleOwnerVehicleNumber = vehicleOwnerVehicleNumber;
	}

	public String getVehicleOwnerChassisNumber() {
		return vehicleOwnerChassisNumber;
	}

	public void setVehicleOwnerChassisNumber(String vehicleOwnerChassisNumber) {
		this.vehicleOwnerChassisNumber = vehicleOwnerChassisNumber;
	}

	public String getVehicleOwnerEngineNumber() {
		return vehicleOwnerEngineNumber;
	}

	public void setVehicleOwnerEngineNumber(String vehicleOwnerEngineNumber) {
		this.vehicleOwnerEngineNumber = vehicleOwnerEngineNumber;
	}

	public String getVehicleOwnerDrivingLicence() {
		return vehicleOwnerDrivingLicence;
	}

	public void setVehicleOwnerDrivingLicence(String vehicleOwnerDrivingLicence) {
		this.vehicleOwnerDrivingLicence = vehicleOwnerDrivingLicence;
	}

	public String getMobileInformation() {
		return mobileInformation;
	}

	public void setMobileInformation(String mobileInformation) {
		this.mobileInformation = mobileInformation;
	}

	public String getOtherInformation() {
		return otherInformation;
	}

	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}

	public int getDataEnteredBy() {
		return dataEnteredBy;
	}

	public void setDataEnteredBy(int dataEnteredBy) {
		this.dataEnteredBy = dataEnteredBy;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "VehicleOwnerEntries [vehicleOwnerId=" + vehicleOwnerId + ", idCardNumber=" + idCardNumber
				+ ", vehicleDistrictId=" + vehicleDistrictId + ", vehicleBarrierId=" + vehicleBarrierId
				+ ", vehicleTypeId=" + vehicleTypeId + ", vehicleOwnerTypeId=" + vehicleOwnerTypeId
				+ ", vehicleOwnerName=" + vehicleOwnerName + ", vehicleOwnerImageName=" + vehicleOwnerImageName
				+ ", vehicleOwnerMobileNumber=" + vehicleOwnerMobileNumber + ", isValidFrom=" + isValidFrom
				+ ", isValidUpto=" + isValidUpto + ", vehicleOwnerAadhaarNumber=" + vehicleOwnerAadhaarNumber
				+ ", vehicleOwnerVehicleNumber=" + vehicleOwnerVehicleNumber + ", vehicleOwnerChassisNumber="
				+ vehicleOwnerChassisNumber + ", vehicleOwnerEngineNumber=" + vehicleOwnerEngineNumber
				+ ", vehicleOwnerDrivingLicence=" + vehicleOwnerDrivingLicence + ", mobileInformation="
				+ mobileInformation + ", otherInformation=" + otherInformation + ", dataEnteredBy=" + dataEnteredBy
				+ ", active=" + active + "]";
	}
	
	
	


	
	
	

}
