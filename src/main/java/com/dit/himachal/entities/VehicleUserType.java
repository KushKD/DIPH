package com.dit.himachal.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "mst_vehicle_owner_type")
public class VehicleUserType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3440399909168692855L;

	@Id
	@GeneratedValue(generator = "mst_vehicle_owner_type_vehicle_owner_type_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "mst_vehicle_owner_type_vehicle_owner_type_id_seq", sequenceName = "public.mst_vehicle_owner_type_vehicle_owner_type_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "vehicle_owner_type_id")
	private Integer vehicleOwnerTypeId;

	@Column(name = "vehicle_owner_name")
	private String vehicleOwnerTypeName;

	@Column(name = "active")
	private boolean active;

	public Integer getVehicleOwnerTypeId() {
		return vehicleOwnerTypeId;
	}

	public void setVehicleOwnerTypeId(Integer vehicleOwnerTypeId) {
		this.vehicleOwnerTypeId = vehicleOwnerTypeId;
	}

	public String getVehicleOwnerTypeName() {
		return vehicleOwnerTypeName;
	}

	public void setVehicleOwnerTypeName(String vehicleOwnerTypeName) {
		this.vehicleOwnerTypeName = vehicleOwnerTypeName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "VehicleUserType [vehicleOwnerTypeId=" + vehicleOwnerTypeId + ", vehicleOwnerTypeName="
				+ vehicleOwnerTypeName + ", active=" + active + "]";
	}

	
	
	

	
	
	
	

}
