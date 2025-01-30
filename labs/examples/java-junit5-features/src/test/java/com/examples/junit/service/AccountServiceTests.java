package com.examples.junit.service;

import com.examples.junit.model.Account;
import com.examples.junit.repo.AccountDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountServiceTests {

    AccountDao accountFakeDao = new AccountFakeDaoImpl();
    AccountService service = new AccountServiceImpl(accountFakeDao);

    @Test
    public void testCreateAccount() {
        Account account = new Account();
        account.setId(10);
        account.setName("Senthil");
        account.setType("Savings");
        account.setBalance(10000.0);

        boolean status = service.createAccount(account);
        Assertions.assertTrue(status);

    }
}
