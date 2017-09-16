package com.manish.javadev.service;

import java.util.List;

import com.manish.javadev.model.AccountEntity;

/**
 * @author Manish
 *
 */
public interface AccountService {
	AccountEntity createAccount(AccountEntity accountEntity);

	AccountEntity findByAccountNumbere(Long accNumber);

	List<AccountEntity> findAllAccount();
}
