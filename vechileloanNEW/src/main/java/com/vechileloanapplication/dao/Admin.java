package com.vechileloanapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vechileloanapplication.model.AdminEntity;


@RepositoryRestResource(collectionResourceRel="admins",path="admins")
public interface Admin extends JpaRepository<AdminEntity,String> {

}
