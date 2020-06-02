package com.acme.banking.dbo;

import com.acme.banking.PositiveTest;
import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class SavingAccountTest {
    final UUID dummyStubId = UUID.randomUUID();
    final UUID dummyClientId = UUID.randomUUID();
    final Client dummyClient = new Client(dummyClientId, "dummy client name");
    final double dummyAmt = 1.0;
    SavingAccount sut = new SavingAccount(dummyStubId, dummyClient, dummyAmt);

    //Leave old good JUnit4 style here
    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCreateWithNullClient() {
        new SavingAccount(dummyStubId, null, dummyAmt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCreateWithNullId() {
        new SavingAccount(null, dummyClient, dummyAmt);
    }

    @Category(PositiveTest.class)
    @Test
    public void shouldSavePropertiesWhenCreated() {
        assertThat(sut,
                allOf(
                        hasProperty("id", is(dummyStubId)),
                        hasProperty("client", is(dummyClient)),
                        hasProperty("clientId", is(dummyClientId)),
                        hasProperty("amount", is(dummyAmt))
                ));

        assertThat(dummyClient.getAccounts(),
                Matchers.allOf(
                        iterableWithSize(Matchers.equalTo(1)),
                        hasItem(sut)
                ));
    }

}