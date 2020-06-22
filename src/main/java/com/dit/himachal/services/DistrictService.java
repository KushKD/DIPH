package com.dit.himachal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dit.himachal.entities.DistrictMaster;
import com.dit.himachal.entities.StatesMaster;
import com.dit.himachal.repositories.DistrictRepository;
import com.dit.himachal.repositories.StateRepository;

@Service
public class DistrictService {
	
	@Autowired
	private DistrictRepository districtRepository;

	
	
	public DistrictRepository getDistrictRepository() {
		return districtRepository;
	}



	public void setDistrictRepository(DistrictRepository districtRepository) {
		this.districtRepository = districtRepository;
	}


  
	public List<DistrictMaster> getDistricts(int state_id) throws Exception {
		List<DistrictMaster> districts = (List<DistrictMaster>)districtRepository.findByStateId(state_id);
		return districts;
	}

}
