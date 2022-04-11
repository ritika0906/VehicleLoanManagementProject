package com.vechileloanapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vechileloanapplication.model.UserRegistrationEntity;

@RepositoryRestResource(collectionResourceRel="users",path="users")
public interface UserRegister extends JpaRepository<UserRegistrationEntity,String> {

}


	
