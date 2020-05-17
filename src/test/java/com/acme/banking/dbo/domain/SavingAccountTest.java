package com.acme.banking.dbo.domain;

import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SavingAccountTest {
    final UUID dummyStubId = UUID.randomUUID();
    final UUID dummyClientId = UUID.randomUUID();
    final Client dummyClient = new Client(dummyClientId, "dummy client name");
    final double dummyAmt = 1.0;

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCreateWithNullClient() {
        new SavingAccount(dummyStubId, null, dummyAmt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCreateWithNullId() {
        new SavingAccount(null, dummyClient, dummyAmt);
    }

    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        //endregion

        //region when
        SavingAccount sut = new SavingAccount(dummyStubId, dummyClient, dummyAmt);
        //endregion

        //region then
        assertThat(sut.getId(), equalTo(dummyStubId));
        assertThat(sut.getClient(), equalTo(dummyClient));
        assertThat(sut.getClientId(), equalTo(dummyClientId));
        //TODO: use JUnit assert -- better to import Hamcrest Matchers and use closeTo
        assertEquals(sut.getAmount(), dummyAmt, 0.0001);
        //endregion
    }
}