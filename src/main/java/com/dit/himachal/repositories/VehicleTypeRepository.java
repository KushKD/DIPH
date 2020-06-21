package com.dit.himachal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dit.himachal.entities.VehicleTypeMaster;

@Repository
public interface VehicleTypeRepository extends CrudRepository<VehicleTypeMaster, Integer> {

}
