package com.manish.javadev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manish.javadev.model.AccountEntity;
import com.manish.javadev.repository.AccountRepository;

/**
 * @author Manish
 *
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public void setPersonDAO(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public AccountEntity createAccount(AccountEntity accountEntity) {
		AccountEntity acccountResult = accountRepository.save(accountEntity);
		return acccountResult;
	}

	@Override
	public AccountEntity findByAccountNumbere(Long number) {
		return accountRepository.findOne(number);
	}

	@Override
	public List<AccountEntity> findAllAccount() {
		return (List<AccountEntity>) accountRepository.findAll();
	}

}
