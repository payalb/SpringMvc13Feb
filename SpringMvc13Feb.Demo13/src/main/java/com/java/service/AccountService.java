package com.java.service;

import java.util.List;
import java.util.Optional;

import com.java.dto.Account;

public interface AccountService {

	public void addAccount(Account account);
	public void removeAccount(int accountNumber);
	public void updateAccount(Account account);
	public Iterable<Account> getAccounts();
	public Optional<Account> getAccountByNumber(int accountNumber);
}
