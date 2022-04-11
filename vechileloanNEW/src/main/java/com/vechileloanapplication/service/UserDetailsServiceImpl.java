package com.vechileloanapplication.service;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vechileloanapplication.controller.UserDetailsCont;
import com.vechileloanapplication.dao.UserDetails;
import com.vechileloanapplication.dao.UserRegister;
import com.vechileloanapplication.exceptions.RecordNotFoundException;
import com.vechileloanapplication.model.UserDetailsEntity;
import com.vechileloanapplication.model.UserRegistrationEntity;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	public static Logger log = Logger.getLogger(UserDetailsCont.class.getName());
	
	@Autowired
	private UserDetails userDetailsRepo;
    
	@Autowired
	private UserRegister userRegisterRepo;
	
	//ADDING USERDETAILS
	@Override
	public List<UserDetailsEntity> addUserDetails(UserDetailsEntity useradvanced, String email) throws RecordNotFoundException {
		
		log.info("Service Layer - Entry - addUserDetails");
		
		UserDetailsEntity user = new UserDetailsEntity();
		
		if(useradvanced.getAadhar().isEmpty() || useradvanced.getAddress().isEmpty() || useradvanced.getCity().isEmpty())
		{
			log.warn("WARN: UserDetails Should not be empty");
			throw new RecordNotFoundException("User details should not be null");
		}
		else if(userRegisterRepo.findById(email)==null) {
			throw new RecordNotFoundException("User not registered");
		}
		log.info("Service Layer - Exit - addUserDetails");
		
		Optional<UserRegistrationEntity> userRegister =userRegisterRepo.findById(email);
	    UserRegistrationEntity userReg=userRegister.get();
		
		if(userReg!=null && userReg.getUserdetails()==null ) {
		user = userDetailsRepo.saveAndFlush(useradvanced); 
		userReg.setUserdetails(useradvanced);
		userRegisterRepo.saveAndFlush(userReg);
		}
		List<UserDetailsEntity> list=userDetailsRepo.findAll();
		return list;
	}


	@Override
	public List<UserDetailsEntity> editUserDetails(UserDetailsEntity user ) throws RecordNotFoundException{
		log.info("Service Layer - Entry - EditUserDetails");
		if(user.getUserId()==0) {
			log.warn("WARN: UserId Should not be empty");
			throw new RecordNotFoundException("User Not Found...");
		}
		log.info("Service Layer - Entry - EditserDetails");
		userDetailsRepo.save(user);
		return userDetailsRepo.findAll();	
	}

	@Override
	public UserDetailsEntity showUserDetailsInformationByUserId(int userId) throws RecordNotFoundException{
		log.info("Service Layer - Entry - ShowUserDetails");
		Optional<UserDetailsEntity>user=userDetailsRepo.findById(userId);
		if(user==null) {
			log.warn("WARN: UserDetails Should not be empty");
			throw new  RecordNotFoundException("No Records Found");
		}
		log.info("Service Layer - Exit - ShowUserDetails");
		return user.get();	
	}
	@Override
	public List<UserDetailsEntity> showAllUserDetails() throws RecordNotFoundException{
		log.info("Service Layer - Entry - ShowUserDetails");
		//Optional<UserDetailsEntity> user=userDetailsRepo.save();
		log.info("Service Layer - Exit - ShowUserDetails");
		return userDetailsRepo.findAll();
	}
}







