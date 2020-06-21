package com.dit.himachal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dit.himachal.entities.StatesMaster;
import com.dit.himachal.entities.VehicleTypeMaster;
import com.dit.himachal.entities.VehicleUserType;
import com.dit.himachal.repositories.StateRepository;
import com.dit.himachal.repositories.VehicleTypeRepository;
import com.dit.himachal.repositories.VehicleUserTypeRepository;

@Service
public class VehicleUserTypeService {

	@Autowired
	private VehicleUserTypeRepository vehicleUserTypeRepository;

	public VehicleUserTypeRepository getVehicleUserTypeRepository() {
		return vehicleUserTypeRepository;
	}

	public void setVehicleUserTypeRepository(VehicleUserTypeRepository vehicleUserTypeRepository) {
		this.vehicleUserTypeRepository = vehicleUserTypeRepository;
	}

	public List<VehicleUserType> getVehicleUserTypes() {
		List<VehicleUserType> vehicleUserTypes = (List<VehicleUserType>) vehicleUserTypeRepository.findAll();
		return vehicleUserTypes;
	}

}
