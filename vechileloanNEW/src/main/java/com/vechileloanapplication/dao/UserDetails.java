package com.vechileloanapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vechileloanapplication.model.UserDetailsEntity;



@RepositoryRestResource(collectionResourceRel="userDetails",path="userDetails")
public interface UserDetails extends JpaRepository<UserDetailsEntity,Integer> {
    
	//public UserDetailsEntity findByEmail(@Param("email") String email);
}
