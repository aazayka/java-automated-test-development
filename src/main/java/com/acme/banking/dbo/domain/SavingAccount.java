package com.acme.banking.dbo.domain;

import java.util.UUID;

public class SavingAccount implements Account {
    private UUID id;
    private Client client;
    private double amount;

    public SavingAccount(UUID id, Client client, double amount) {
        if (id == null) throw new IllegalArgumentException("ID shouldn't be null");
        if (client == null) throw new IllegalArgumentException("Client shouldn't be null");

        this.id = id;
        this.client = client;
        this.amount = amount;
        client.addAccount(this);
    }

    public Client getClient() {
        return client;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public UUID getClientId() {
        return client.getId();
    }

    @Override
    public void withdraw(double amount) {
        //TODO
    }

    @Override
    public void deposit(double amount) {
        //TODO
    }
}
