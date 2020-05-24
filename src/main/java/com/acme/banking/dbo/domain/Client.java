package com.acme.banking.dbo.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class Client {
    private UUID id;
    private String name;
    private Collection<Account> accounts = new HashSet<>();

    public Client(UUID id, String name) {
        if (id == null) throw new IllegalArgumentException("ID shouldn't be null");
        if (isEmpty(name)) throw new IllegalArgumentException("Name shouldn't be empty");

        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        if (account == null) throw new IllegalArgumentException("Account is null");
        if(!id.equals(account.getClientId())) throw new IllegalArgumentException("Account cheating");
        accounts.add(account);
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }
}
