package com.acme.banking.dbo.domain;

import com.acme.banking.PositiveTest;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.junit.Assert.assertEquals;
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
        assertThat(sut.getId(), equalTo(dummyStubId));
        assertThat(sut.getClient(), equalTo(dummyClient));
        assertThat(sut.getClientId(), equalTo(dummyClientId));
        assertEquals(sut.getAmount(), dummyAmt, 0.0001);

        assertThat(dummyClient.getAccounts(),
                Matchers.allOf(
                        iterableWithSize(Matchers.equalTo(1)),
                        hasItem(sut)
                ));
    }

}