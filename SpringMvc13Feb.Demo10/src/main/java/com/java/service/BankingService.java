package com.java.service;

import java.util.List;

import com.java.dto.Account;
import com.java.dto.TransferForm;

public interface BankingService {
	
	public void transferMoney(TransferForm form);
	public void addAccounts(List<Account> account);
}
