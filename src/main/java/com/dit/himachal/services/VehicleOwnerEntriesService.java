package com.dit.himachal.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dit.himachal.entities.VehicleOwnerEntries;
import com.dit.himachal.repositories.VehicleOwnerEntriesRepository;

import java.util.Optional;

@Service
public class VehicleOwnerEntriesService {
	
	@Autowired
	private VehicleOwnerEntriesRepository vehicleOwnerEntriesRepository;

	public VehicleOwnerEntriesRepository getVehicleOwnerEntriesRepository() {
		return vehicleOwnerEntriesRepository;
	}

	public void setVehicleOwnerEntriesRepository(VehicleOwnerEntriesRepository vehicleOwnerEntriesRepository) {
		this.vehicleOwnerEntriesRepository = vehicleOwnerEntriesRepository;
	}
	
	public Long saveVehicleOwnerEntries(VehicleOwnerEntries object) {
		VehicleOwnerEntries savedData = vehicleOwnerEntriesRepository.save(object);
		return savedData.getVehicleOwnerId();
	}
	
	public Long getIdCardNumberSequence() {
		return  vehicleOwnerEntriesRepository.getNextSeriesId();
		
	}

	public Optional<VehicleOwnerEntries> getOwnerDetails(Long id) {

		return  vehicleOwnerEntriesRepository.findById(id);

	}

}
