package com.acme.banking.dbo.service;

import com.acme.banking.dbo.dal.AccountRepository;
import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Cash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

import static org.springframework.util.StringUtils.isEmpty;

@Service
public class Processing {

    @Autowired
    private AccountRepository accounts;

    @Autowired
    private Cash cash;

    public Collection<Account> getAccountsByClientId(UUID clientId) {
        if (clientId == null || isEmpty(clientId)) throw new IllegalArgumentException("Please provide ClientId");
        return accounts.findAccountsByClientId(clientId);
    }

    public void transfer(double amount, UUID fromAccountId, UUID toAccountId) {
        Account a1 = accounts.findAccountById(fromAccountId);
        Account a2 = accounts.findAccountById(toAccountId);
        a1.withdraw(amount);
        a2.deposit(amount);
    }

    public void cash(double amount, UUID fromAccountId) {
        cash.log(amount, fromAccountId);
    }
}
