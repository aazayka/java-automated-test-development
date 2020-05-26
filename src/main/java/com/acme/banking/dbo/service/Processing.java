package com.acme.banking.dbo.service;

import com.acme.banking.dbo.dal.AccountRepository;
import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Cash;
import com.acme.banking.dbo.domain.SavingAccount;

import java.util.Collection;
import java.util.UUID;

public class Processing {
    private AccountRepository accounts;

    public Processing(AccountRepository accounts) {
        this.accounts = accounts;
    }

    public UUID createClient(String name) {
        return null;
    }

    public Collection<Account> getAccountsByClientId(UUID clientId) {
        return accounts.findAccountsByClientId(clientId);
    }

    public void transfer(double amount, UUID fromAccountId, UUID toAccountId) {
        Account a1 = accounts.findAccountById(fromAccountId);
        Account a2 = accounts.findAccountById(toAccountId);
        a1.withdraw(amount);
        a2.deposit(amount);
    }

    public void cash(double amount, UUID fromAccountId) {

        Cash.log(amount, fromAccountId);
    }
}
