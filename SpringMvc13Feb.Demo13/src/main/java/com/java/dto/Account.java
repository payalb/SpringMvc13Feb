package com.java.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

	@Id
	@GeneratedValue
	int accountNumber;
	String bank;
	float balance;
	int version;
	
	public Account(String bank, float balance){
		this.bank= bank;
		this.balance= balance;
	}
	
}
