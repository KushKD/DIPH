package com.dit.himachal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dit.himachal.entities.StatesMaster;
import com.dit.himachal.repositories.StateRepository;

@Service
public class StatesService {
	
	@Autowired
	private StateRepository stateRepository;

	public StateRepository getStateRepository() {
		return stateRepository;
	}

	public void setStateRepository(StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}
	
	public List<StatesMaster> getStates() {
		List<StatesMaster> states = (List<StatesMaster>) stateRepository.findAll();
		return states;
	}

}
