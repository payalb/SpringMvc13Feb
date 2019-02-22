package com.java.repository;

import com.java.dto.Account;

public interface BankingRepository {
	public void withdrawMoney(Account fromAccount, float amount);
	public void depositMoney(Account toAccount, float amount);
	public void addAccount(Account account);
}
