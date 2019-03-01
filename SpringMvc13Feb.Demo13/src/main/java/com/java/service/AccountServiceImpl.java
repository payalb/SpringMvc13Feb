package com.java.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Account;
import com.java.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired AccountRepository rep;
	@Override
	public void addAccount(Account account) {
		rep.save(account);
		
	}

	@Override
	public void removeAccount(int accountNumber) {
		rep.deleteById(accountNumber);
		
	}

	@Override
	public void updateAccount(Account account) {
		rep.save(account);
		
	}

	@Override
	public Iterable<Account> getAccounts() {
		return rep.findAll();
	}

	@Override
	public Optional<Account> getAccountByNumber(int accountNumber) {
		return rep.findById(accountNumber);
	}

}
