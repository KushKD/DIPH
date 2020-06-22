package com.dit.himachal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dit.himachal.entities.DistrictMaster;


@Repository
public interface DistrictRepository extends CrudRepository<DistrictMaster, Integer> {
	
	
	 
	 @Query(value="select * from mst_district where state_id=:stateId", nativeQuery = true)
		List<DistrictMaster> findByStateId(@Param("stateId") int stateId) throws Exception;
	 
	


}
