package com.valtech.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.account.entity.Account;
import com.valtech.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;
	
	public Account createAccount(Account acc){
		return accountRepo.save(acc);
		
	}
	
	
	public Account updateAccount(Account acc){
		return accountRepo.save(acc);
		
	}
	
	public Account getAccount(long id){
		return accountRepo.findById(id).get();
		
	}
	
	public List<Account> getAllAccount(){
		return accountRepo.findAll();
		
	}


	@Override
	public Account createSavingsAccount(double balance) {
		String accountType="SA";
		Account ac1=new Account(accountType, balance);
		return ac1;
	}


	@Override
	public Account createCurrentAccount(double balance) {
		String accountType="CA";
		
		Account ac1=new Account(accountType, balance);
		return ac1;
	}
}
