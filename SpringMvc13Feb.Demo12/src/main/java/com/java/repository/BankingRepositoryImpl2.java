package com.java.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Account;
import com.java.exception.InvalidStateException;

@Repository
@Primary
public class BankingRepositoryImpl2 implements BankingRepository {

	@Autowired HibernateTemplate template;
	@Transactional(propagation= Propagation.REQUIRED, isolation= Isolation.READ_COMMITTED)
	@Override
	public void withdrawMoney(Account fromAccount, float amount) {
		Account obj=template.get(Account.class, fromAccount.getAccountNumber());
		if(obj.getBalance()>= amount) {
			/*obj.setBalance(obj.getBalance()-amount);
			obj.setVersion(obj.getVersion()+1);*/
			/*template.update(obj);: Wrong*/
			//u also need to match the version
		//	template.bulkUpdate("update account set balance =? and version =? where version= ? and accountNumber= ?", new Object[] {obj.getBalance()-amount, obj.getVersion()+1,obj.getVersion(), obj.getAccountNumber() });
	/*	template.execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				return null;
			}
			
		});*/
			
		}else {
			throw new InvalidStateException("Insufficient Balance!");
		}
	}
	
	@Transactional(propagation= Propagation.REQUIRED)
	@Override
	public void depositMoney(Account toAccount, float amount) {
		toAccount.setBalance(toAccount.getBalance()+ amount);
		template.update(toAccount);
		
	}

	@Override
	public void addAccount(Account account) {
		template.save(account);
		
	}

}
