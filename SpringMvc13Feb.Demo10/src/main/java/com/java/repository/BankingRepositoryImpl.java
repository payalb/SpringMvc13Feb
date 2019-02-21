package com.java.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.java.dto.Account;
import com.java.exception.InvalidStateException;

@Repository
public class BankingRepositoryImpl implements BankingRepository {

	@Autowired JdbcTemplate template;
	@Override
	public void withdrawMoney(Account fromAccount, float amount) {
		
		Float sum=	template.queryForObject("select balance from account where accountNumber= "+ fromAccount.getAccountNumber(), Float.class);
		if(sum>=amount) {	
		template.update("update account set balance= ? where accountNumber =?",new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setFloat(1, sum-amount);
					ps.setInt(2, fromAccount.getAccountNumber());
				}
			} );
		}else {
			throw new InvalidStateException("Amount insufficient in account, unable to withdraw"+ amount);
		}

	}

	@Override
	public void depositMoney(Account toAccount, float amount) {
		
		template.update("update account set balance = balance + ? where accountNumber =?",new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setFloat(1, amount);
				ps.setInt(2, toAccount.getAccountNumber());
			}
		} );
		
	}

}
