package com.dit.himachal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dit.himachal.entities.VehicleOwnerDocuments;
import com.dit.himachal.entities.VehicleOwnerEntries;
import com.dit.himachal.repositories.VehicleOwnerDocumentsRepository;
import com.dit.himachal.repositories.VehicleOwnerEntriesRepository;

@Service
public class VehicleOwnerDocumentsService {
	
	@Autowired
	private VehicleOwnerDocumentsRepository vehicleOwnerDocumentsRepository;

	

	public VehicleOwnerDocumentsRepository getVehicleOwnerDocumentsRepository() {
		return vehicleOwnerDocumentsRepository;
	}


	public void setVehicleOwnerDocumentsRepository(VehicleOwnerDocumentsRepository vehicleOwnerDocumentsRepository) {
		this.vehicleOwnerDocumentsRepository = vehicleOwnerDocumentsRepository;
	}



	public Long saveDocuments(VehicleOwnerDocuments object) {
		VehicleOwnerDocuments savedData = vehicleOwnerDocumentsRepository.save(object);
		return savedData.getDocId();
	}

}
