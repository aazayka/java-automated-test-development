package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.fail;

public class SavingAccountTest {
    @Test
    public void shouldNotCreateAccountWhenNullId() {
        try {
            //region Given
            final UUID dummyUuid = null;
            final Client dummyClient = new Client(dummyUuid, null);
            //endregion

            //region When
            new SavingAccount(null, dummyClient, 0);
            //endregion
            fail();
        } catch (IllegalArgumentException e) {

        }
    }
}
