package com.dit.himachal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dit.himachal.entities.BarrierMaster;
import com.dit.himachal.entities.StatesMaster;
import com.dit.himachal.repositories.BarrierRepository;
import com.dit.himachal.repositories.StateRepository;

@Service
public class BarrierService {
	
	@Autowired
	private BarrierRepository barrierRepository;

	
	
	public BarrierRepository getBarrierRepository() {
		return barrierRepository;
	}



	public void setBarrierRepository(BarrierRepository barrierRepository) {
		this.barrierRepository = barrierRepository;
	}



	public List<BarrierMaster> getBarriers(int districtId) {
		List<BarrierMaster> barriers = (List<BarrierMaster>) barrierRepository.findBarrierByDistrictId(districtId);
		return barriers;
	}
	
	public String getBarrierName(int barrierId) {
		return barrierRepository.getBarrierNameByBarrierId(barrierId);
	}

}
