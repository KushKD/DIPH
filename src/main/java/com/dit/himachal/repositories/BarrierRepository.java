package com.dit.himachal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dit.himachal.entities.BarrierMaster;

@Repository
public interface BarrierRepository extends CrudRepository<BarrierMaster, Integer> {

	 @Query(value="select * from public.mst_barrier where district_id=:districtId", nativeQuery = true)
		List<BarrierMaster> findBarrierByDistrictId(@Param("districtId") int districtId);
	 
	 @Query(value="SELECT barrier_name FROM public.mst_barrier WHERE barrier_id =:barrierId", nativeQuery = true)
	String getBarrierNameByBarrierId(@Param("barrierId") int barrierId);
}
