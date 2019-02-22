package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	int accountNumber;
	String bank;
	float balance;
	int version;
	
	public Account(String bank, float balance){
		this.bank= bank;
		this.balance= balance;
	}
	
}
