package com.dit.himachal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dit.himachal.entities.VehicleTypeMaster;
import com.dit.himachal.entities.VehicleUserType;

@Repository
public interface VehicleUserTypeRepository extends CrudRepository<VehicleUserType, Integer> {

}
