package com.teste.RESTService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.teste.RESTService.entity.Account;
import com.teste.RESTService.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository repository;
	
	public Optional<Account> getByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public Account insertAccount(Account account) {
		return repository.saveAndFlush(account);
	}
	
	public void deleteAccount(Account account) {
		repository.delete(account);
	}
	
	public List<Account> listAllAccount(){
		return repository.findAll();
	}

}
