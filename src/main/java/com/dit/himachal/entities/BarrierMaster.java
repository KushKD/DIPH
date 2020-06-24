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
@Table(name = "mst_barrier")
public class BarrierMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3440391786168692855L;

	@Id
	@GeneratedValue(generator = "mst_barrier_barrier_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "mst_barrier_barrier_id_seq", sequenceName = "public.mst_barrier_barrier_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "barrier_id")
	private Integer barrierId;

	@Column(name = "barrier_name")
	private String barrierName;
	
	@Column(name = "district_id")
	private Integer districtId;

	@Column(name = "active")
	private boolean active;

	public Integer getBarrierId() {
		return barrierId;
	}

	public void setBarrierId(Integer barrierId) {
		this.barrierId = barrierId;
	}

	public String getBarrierName() {
		return barrierName;
	}

	public void setBarrierName(String barrierName) {
		this.barrierName = barrierName;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "BarrierMaster [barrierId=" + barrierId + ", barrierName=" + barrierName + ", districtId=" + districtId
				+ ", active=" + active + "]";
	}

	
	
	
	
	

}
