package com.dit.himachal.services;

import com.dit.himachal.entities.VehicleOwnerEntries;
import com.dit.himachal.repositories.VehicleOwnerEntriesRepository;

public class VehicleOwnerEntriesService {
	
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

}
