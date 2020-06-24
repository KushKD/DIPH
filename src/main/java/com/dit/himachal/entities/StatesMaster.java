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
@Table(name = "mst_state")
public class StatesMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3440391786168692855L;

	@Id
	@GeneratedValue(generator = "mst_state_state_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "mst_state_state_id_seq", sequenceName = "public.mst_state_state_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "state_id")
	private Integer stateId;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "active")
	private boolean active;

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "StatesMaster [stateId=" + stateId + ", stateName=" + stateName + ", active=" + active + "]";
	}
	
	
	

}
