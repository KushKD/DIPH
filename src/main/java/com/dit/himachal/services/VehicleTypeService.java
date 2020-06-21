package com.dit.himachal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dit.himachal.entities.StatesMaster;
import com.dit.himachal.entities.VehicleTypeMaster;
import com.dit.himachal.repositories.StateRepository;
import com.dit.himachal.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

	public VehicleTypeRepository getVehicleTypeRepository() {
		return vehicleTypeRepository;
	}

	public void setVehicleTypeRepository(VehicleTypeRepository vehicleTypeRepository) {
		this.vehicleTypeRepository = vehicleTypeRepository;
	}

	public List<VehicleTypeMaster> getVehicleTypes() {
		List<VehicleTypeMaster> vehicleTypes = (List<VehicleTypeMaster>) vehicleTypeRepository.findAll();
		return vehicleTypes;
	}

}
