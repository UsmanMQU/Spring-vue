package com.QA.account.controllers;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.QA.account.models.Account;
import com.QA.account.repositories.AccountRepository;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController 
{
	
	private static Logger logger = Logger.getLogger("example");
	@Autowired
	private AccountRepository accountRepository;
	@GetMapping
	public List<Account> list()
	{
		return accountRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Account bike)
	{
		logger.error("exception:");
		accountRepository.save(bike);
	}	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id)
	{
		Account account = accountRepository.getById(id);
		accountRepository.delete(account);
	}
	
	@GetMapping("/{id}")
	public Account get(@PathVariable("id") long id)
	{
		return accountRepository.getOne(id);
	}
	
	
	
}
