package com.examples.junit.service;

import com.examples.junit.model.Account;
import com.examples.junit.repo.AccountDao;

import java.util.List;

public class AccountFakeDaoImpl implements AccountDao {

    @Override
    public boolean createAccount(Account account) {
        return true;
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
