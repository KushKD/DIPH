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
@Table(name = "mst_vehicle_type")
public class VehicleTypeMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3440391709168692855L;

	@Id
	@GeneratedValue(generator = "mst_vehicle_type_vehicle_type_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "mst_vehicle_type_vehicle_type_id_seq", sequenceName = "public.mst_vehicle_type_vehicle_type_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "vehicle_type_id")
	private Integer vehicleId;

	@Column(name = "vehicle_type_name")
	private String vehicleName;

	@Column(name = "active")
	private boolean active;

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "VehicleTypeMaster [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", active=" + active
				+ "]";
	}
	
	

	
	
	
	

}
