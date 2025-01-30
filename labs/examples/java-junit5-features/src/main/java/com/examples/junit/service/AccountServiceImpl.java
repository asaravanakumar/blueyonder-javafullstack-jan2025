package com.examples.junit.service;

import com.examples.junit.model.Account;
import com.examples.junit.repo.AccountDao;
import com.examples.junit.repo.AccountDaoJdbcImpl;

import java.util.List;

public class AccountServiceImpl implements AccountService{

    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public boolean createAccount(Account account) {
        return false;
    }

    @Override
    public boolean updateAccount(int id, Account account) {
        return false;
    }

    @Override
    public boolean deleteAccount(Account account) {
        return false;
    }

    @Override
    public Account getAccount(int id) {
        return null;
    }

    @Override
    public List<Account> getAccounts() {
        return null;
    }
}
