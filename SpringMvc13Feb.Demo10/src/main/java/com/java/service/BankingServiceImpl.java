package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.TransferForm;
import com.java.repository.BankingRepository;

@Service
@Transactional(transactionManager="tm")
public class BankingServiceImpl implements BankingService{

	@Autowired BankingRepository rep;
	@Override
	public void transferMoney(TransferForm form) {
		rep.withdrawMoney(form.getFromAccount(), form.getAmount());
		rep.depositMoney(form.getToAccount(), form.getAmount());
	}

}
