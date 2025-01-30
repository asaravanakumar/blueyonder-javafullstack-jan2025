package com.examples.junit.repo;

import com.examples.junit.model.Account;

import java.util.List;

public interface AccountDao {
    public boolean createAccount(Account account);
    public boolean updateAccount(int id, Account account);
    public boolean deleteAccount(Account account);
    public Account getAccount(int id);
    public List<Account> getAccounts();
}
