package com.java.repository;

import org.springframework.data.repository.CrudRepository;

import com.java.dto.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{

}
