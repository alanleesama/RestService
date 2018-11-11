package com.teste.RESTService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.RESTService.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	public Optional<Account> findByEmail(String email);

}
