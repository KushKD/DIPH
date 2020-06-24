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
@Table(name = "mst_district")
public class DistrictMaster implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1336386142311829336L;

	@Id
	@GeneratedValue(generator = "mst_district_district_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "mst_district_district_id_seq", sequenceName = "public.mst_district_district_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "district_id")
	private Integer districtId;

	@Column(name = "district_name")
	private String districtName;
	
	@Column(name = "state_id")
	private Integer stateId;

	@Column(name = "active")
	private boolean active;

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "DistrictMaster [districtId=" + districtId + ", districtName=" + districtName + ", stateId=" + stateId
				+ ", active=" + active + "]";
	}
	
	


	
	

}
