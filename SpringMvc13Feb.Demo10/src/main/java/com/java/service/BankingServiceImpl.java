package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Account;
import com.java.dto.TransferForm;
import com.java.repository.BankingRepository;

@Service
@Transactional(transactionManager = "tm", propagation= Propagation.REQUIRES_NEW)
public class BankingServiceImpl implements BankingService {

	@Autowired
	BankingRepository rep;

	@Override
	public void transferMoney(TransferForm form) {
		rep.withdrawMoney(form.getFromAccount(), form.getAmount());
		rep.depositMoney(form.getToAccount(), form.getAmount());
	}

	public void addAccounts(List<Account> account) {//10 :1 account insertion fails
		for (Account ac : account) {
			rep.addAccount(ac);
		}
	}
}
