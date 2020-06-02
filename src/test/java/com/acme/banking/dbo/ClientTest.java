package com.acme.banking.dbo;

import com.acme.banking.PositiveTest;
import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Verifier;

import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ClientTest {
    final UUID dummyStubId = UUID.randomUUID();
    final String dummyClientName = "dummy client name";
    final Client sut = new Client(dummyStubId, dummyClientName);
    final SavingAccount dummyAccount = new SavingAccount(UUID.randomUUID(), sut, 123.0);

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    private String context = "clean";
    @Rule
    public final Verifier verifier = new Verifier() {
        @Override
        protected void verify() {

            //Verifier test
            //assertj test
            org.assertj.core.api.Assertions
                    .assertThat(context).isEqualTo("clean");
        }
    };

    @Test
    @Ignore
    public void verifierTest() {
        context = "dirty";
    }

    @Category(PositiveTest.class)
    @Test
    public void shouldSavePropertiesWhenCreated() {
        assertThat(sut,
                allOf(
                        hasProperty("id", equalTo(dummyStubId)),
                        hasProperty("name", equalTo(dummyClientName)))
        );
    }

    @Category(PositiveTest.class)
    @Test
    public void shouldReturnAccountWhenAdd() {
        sut.addAccount(dummyAccount);
        assertThat(sut.getAccounts(),
                Matchers.allOf(
                        iterableWithSize(equalTo(1)),
                        hasItem(dummyAccount)
                ));

    }

    @Test
    public void shouldReturnOnlyAccountWhenAddTwice() {
        sut.addAccount(dummyAccount);
        sut.addAccount(dummyAccount);
        assertThat(sut.getAccounts(),
                Matchers.allOf(
                        iterableWithSize(equalTo(1)),
                        hasItem(dummyAccount)
                ));

    }

    @Test
    public void shouldRaiseExceptionWhenAddInvalidAccount() {
        Client dummyDifferentClient = new Client(UUID.randomUUID(), "Give me your money");
        SavingAccount dummyInvalidAccount = new SavingAccount(UUID.randomUUID(), dummyDifferentClient, 123.0);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(containsString("cheating"));
        sut.addAccount(dummyInvalidAccount);
    }

    @Test
    public void shouldRaiseExceptionWhenAddNullAccount() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(containsString("Account is null"));
        sut.addAccount(null);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void raiseExceptionWhenNullID() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(containsString("ID"));
        new Client(null, dummyClientName);
    }

    @Test
    public void raiseExceptionWhenNullName() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(containsString("Name"));
        new Client(dummyStubId, null);

        //second exception doesn't work
        thrown.expectMessage(containsString("bullshit"));
        new Client(dummyStubId, null);
    }

    @Test
    public void raiseExceptionWhenEmptyName() {
        thrown.expectMessage(containsString("empty"));
        new Client(dummyStubId, "");
    }

    @Test
    public void supressDuplicateWhenAddTheSameAcc() {

    }
}
