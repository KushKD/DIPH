package com.dit.himachal.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dit.himachal.entities.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
  
	
	@Query(value="SELECT * FROM users WHERE mobile_number =:mobile ", nativeQuery = true)
	 UserEntity getUserDetails(@Param("mobile") Long mobile );
}