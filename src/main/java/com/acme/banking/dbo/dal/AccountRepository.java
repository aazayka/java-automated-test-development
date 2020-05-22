package com.acme.banking.dbo.dal;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.SavingAccount;

import java.util.Collection;
import java.util.UUID;

public interface AccountRepository {
    Collection<Account> findAccountsByClientId(UUID clientId);
    SavingAccount findAccountById(UUID fromAccountId);
}
