package com.vechileloanapplication.service;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vechileloanapplication.controller.UserDetailsCont;
import com.vechileloanapplication.dao.Account;
import com.vechileloanapplication.exceptions.RecordNotFoundException;
import com.vechileloanapplication.model.AccountEntity;
@Service
public class AccountServiceImpl implements AccountService{
    public static Logger log = Logger.getLogger(UserDetailsCont.class.getName());
    @Autowired
    private Account accountRepo;

 

    //Getting Account By Email
    @Override
    public AccountEntity getAccountByEmail(String email) throws RecordNotFoundException{

 

        log.info("Service Layer - Entry - AccountDetails");
        Optional<AccountEntity> account=Optional.of(accountRepo.getByEmail(email));
        if(!account.isPresent()) {
            log.warn("WARN: Account Should not be empty");
            throw new RecordNotFoundException("Record doesn't exist");
        }
        log.info("Service Layer - Exit - AccountDetails");
        return account.get();
    }
    
    //Adding Account
    @Override
    public List<AccountEntity> AddAccount(AccountEntity account) throws RecordNotFoundException {
        log.info("Service Layer - Entry - addAccountDetails");
    //    AccountEntity accountEntity=new AccountEntity();
        if(account.getAccountNo()==0) {
            log.warn("WARN: AccountNumber Should not be empty");
            throw new RecordNotFoundException("Record doesn't exist");
        }
        log.info("Service Layer - Exit - addAccountDetails");
        account=accountRepo.saveAndFlush(account);
        //return account;
        return accountRepo.findAll();
        
    }
    //Updating Account
    @Override
    public List<AccountEntity> UpdateAccount(AccountEntity account) throws RecordNotFoundException{
        log.info("Service Layer - Entry - UpdateAccountDetails");
        if(account.getAccountNo()==0) {
            log.warn("WARN: AccountNumber Should not be empty");
            throw new RecordNotFoundException("Record doesn't exist");
        }
        log.info("Service Layer - Exit - UpdateAccountDetails");
        accountRepo.save(account);//save(accountNo);
        return  accountRepo.findAll();
    }
  

 

}
 