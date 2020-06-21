package com.dit.himachal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dit.himachal.entities.StatesMaster;

@Repository
public interface StateRepository extends CrudRepository<StatesMaster, Integer> {

}
