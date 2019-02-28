package com.java.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Account;
import com.java.exception.InvalidStateException;

@Repository
public class BankingRepositoryImpl implements BankingRepository {

	@Autowired JdbcTemplate template;
	@Transactional(propagation=Propagation.REQUIRED, isolation= Isolation.READ_COMMITTED, readOnly=false)
	@Override
	public void withdrawMoney(Account fromAccount, float amount) {
		
		Float sum=	template.queryForObject("select balance, version from account where accountNumber= "+ fromAccount.getAccountNumber(), Float.class);
		if(sum>=amount) {	
		template.update("update account set balance= ?, version= version+1 where accountNumber =? and version=?",new PreparedStatementSetter() {
				
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

	@Transactional(propagation=Propagation.REQUIRED)
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
	

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addAccount(Account account) {
		template.update("insert into account (balance, bank) values (?,?)",account.getBalance(), account.getBank());
		
	}
/*	
	@Transactional(isolation=Isolation.SERIALIZABLE, readOnly=true,rollbackFor=InvalidStateException.class)
	public Account getAccount(int accountNumber, boolean status) {
		template.queryForObject("select * from account where accoutnNumber=? and status= ?", requiredType)
		//work
		template.queryForObject("select * from account where accoutnNumber=? and status= ?", requiredType)
	}*/

}
