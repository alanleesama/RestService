package com.teste.RESTService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste.RESTService.dataobject.ReturnMessage;
import com.teste.RESTService.entity.Account;
import com.teste.RESTService.service.AccountService;

@RestController
public class RESTServiceController {
	
	@Autowired
	AccountService service;
	
	@RequestMapping("/insert")
	public ReturnMessage insertAccount(@RequestParam(value="email", defaultValue="default@email.com")String email, @RequestParam(value="nome", defaultValue="default")String nome, @RequestParam(value="cep", defaultValue="00000-000") String cep) {
		Optional<Account> account = service.getByEmail(email);
		Account conta;
		if(account.isPresent()){
			return new ReturnMessage("Conta já cadastrada.", account.get());
		}else{
			conta = new Account(email,nome,cep);
			service.insertAccount(conta);
			return new ReturnMessage("Conta cadastrada com sucesso.", conta);
		}
	}
	
	@RequestMapping("/get/{email}")
	public ReturnMessage getAccount(@PathVariable("email")String email) {
		Optional<Account> account = service.getByEmail(email);
		if(account.isPresent()){
			return new ReturnMessage("Conta encontrada.", account.get());
		}else{
			return new ReturnMessage("Conta não encontrada.", new Account());
		}
	}
	
	@RequestMapping("/delete/{email}")
	public String deleteAccount(@PathVariable("email")String email) {
		Optional<Account> account = service.getByEmail(email);
        if(account.isPresent()) {
        	service.deleteAccount(account.get());
        	return "Conta deletada com sucesso.";
        }else {
        	return "Conta não existe na base de dados.";
        }
	}
	
	@RequestMapping("/update")
	public ReturnMessage updateAccount(@RequestParam(value="email", defaultValue="default@email.com")String email, @RequestParam(value="nome", defaultValue="default")String nome, @RequestParam(value="cep", defaultValue="00000-000") String cep) {
		Optional<Account> account = service.getByEmail(email);
		if(account.isPresent()){
			account.get().setNome(nome);
			account.get().setCep(cep);
			service.insertAccount(account.get());
			return new ReturnMessage("Conta atualizada com sucesso.", account.get());
		}else{
			return new ReturnMessage("Conta não existe na base.", new Account());
		}
	}
	
	@RequestMapping("/listAll")
	public List<Account> listAllAccounts(){
		return service.listAllAccount();
	}
	

}
