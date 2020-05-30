package com.acme.banking.dbo.domain;

import java.util.UUID;

public interface Cash {
    default void log(double amount, UUID fromAccountId) {
        System.out.println("Денежки тютю");
    }
}
