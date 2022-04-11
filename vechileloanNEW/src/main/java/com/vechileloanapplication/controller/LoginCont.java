package com.vechileloanapplication.controller;
//import com.cg.model.Product;
//import com.cg.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vechileloanapplication.exceptions.DuplicateRecordException;
import com.vechileloanapplication.exceptions.InvalidDetailsException;
import com.vechileloanapplication.exceptions.LoanApplicationException;
import com.vechileloanapplication.exceptions.RecordNotFoundException;
import com.vechileloanapplication.exceptions.RegistrationException;
import com.vechileloanapplication.model.AdminEntity;
import com.vechileloanapplication.model.ApprovedLoansEntity;
import com.vechileloanapplication.model.LoanApplicationEntity;
import com.vechileloanapplication.model.UserDetailsEntity;
import com.vechileloanapplication.model.UserRegistrationEntity;
import com.vechileloanapplication.service.LoginDtoServiceImpl;
@RestController
@RequestMapping("/api/vehicleloans")
public class LoginCont {
	@Autowired
	LoginDtoServiceImpl loginService;
	
	@GetMapping("/userlogin/ul")
	public ResponseEntity<Object> verifyUser(
			String userEmail,String password) throws RegistrationException, RecordNotFoundException, DuplicateRecordException{
		  UserRegistrationEntity retUser = loginService.authenticateUser(userEmail, password);
		  //Log.info(" user signing");
		  EntityModel<UserRegistrationEntity> resource=EntityModel.of(retUser);
		 resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRegisterCont.class).passwordReset(new UserRegistrationEntity())).withRel("change the password"));
	     resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRegisterCont.class).showUserRegistrationInformation("")).withRel("view Registration details"));
		 resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserDetailsCont.class).findUser(0)).withRel("view user details"));
		 resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserDetailsCont.class).updateUser(new UserDetailsEntity())).withRel("update the details"));
		 resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserDetailsCont.class).addUserDetails(" ",new UserDetailsEntity())).withRel("insert the user details"));
		 resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LoanApplicationCont.class).applyLoan(new LoanApplicationEntity(),0)).withRel("apply for the loan"));
//		 resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.)
		 	  
		 return new ResponseEntity<Object>(resource , HttpStatus.OK); 
	}
	
	
	@GetMapping("/adminlogin/ad") 
	public ResponseEntity<Object> adminVerfication(
			String adminEmail,String password) throws RegistrationException, RecordNotFoundException, DuplicateRecordException, InvalidDetailsException, LoanApplicationException{
			AdminEntity admin= loginService.authenticateAdmin(adminEmail, password);//Log.info("admin sign in");
			EntityModel<AdminEntity> resource=EntityModel.of(admin);
			 resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LoanApplicationCont.class).updateLoanApplication(new LoanApplicationEntity())).withRel("update the loan application"));
			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LoanApplicationCont.class).getAllPendingLoans()).withRel("view all pending loans"));
			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ApprovedLoanCont.class).addApprovedLoan(new ApprovedLoansEntity())).withRel("approve an account"));
			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LoanApplicationCont.class).getAllApprovedLoans()).withRel("view all accepted loans"));
			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserDetailsCont.class).findUser(0)).withRel("view user details by Id"));
			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ApprovedLoanCont.class).showAllApprovedByEmail("")).withRel("view all approved loans by email"));
			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRegisterCont.class).getAllUsers()).withRel("view all registerd users"));
			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ApprovedLoanCont.class).showApprovedByLoanId(0)).withRel("view approved loan by id"));
			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ApprovedLoanCont.class).getAllProducts()).withRel("view all accounts"));
			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AdminCont.class).updateAdmin(new AdminEntity())).withRel("update the admin detailsgfhj"));
			  return new ResponseEntity<Object>(resource,HttpStatus.OK);
	}

}