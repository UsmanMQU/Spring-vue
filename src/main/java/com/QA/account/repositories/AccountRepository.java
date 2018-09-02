package com.QA.account.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QA.account.models.Account;


public interface AccountRepository extends JpaRepository<Account, Long> 
{

	Account getById(Long id);

}
