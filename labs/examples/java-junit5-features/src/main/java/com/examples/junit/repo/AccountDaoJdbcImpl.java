package com.examples.junit.repo;

import com.examples.junit.model.Account;

import java.util.List;

// Connects to db and performs CRUD operations
public class AccountDaoJdbcImpl implements AccountDao{
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
