package com.dit.himachal.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.dit.himachal.entities.VehicleOwnerEntries;

public interface VehicleOwnerEntriesRepository extends CrudRepository<VehicleOwnerEntries, Long>{
	
	@Query(value = "SELECT setval('mst_vehicle_owner_entries_vehicle_owner_id_seq',nextval('mst_vehicle_owner_entries_vehicle_owner_id_seq')-1);", nativeQuery =  true)
    Long getNextSeriesId();

}


