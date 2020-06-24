package com.dit.himachal.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dit.himachal.entities.RolesEntity;
import com.dit.himachal.entities.UserEntity;


@Repository
public interface RolesRepository extends CrudRepository<RolesEntity,Integer> {

}