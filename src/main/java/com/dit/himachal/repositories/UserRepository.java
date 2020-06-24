package com.dit.himachal.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dit.himachal.entities.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
   // UserEntity findByUsername(String userName);
}