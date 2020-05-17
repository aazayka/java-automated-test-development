package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ClientTest {
    final UUID dummyStubId = UUID.randomUUID();
    final String dummyClientName = "dummy client name";

    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        //endregion

        //region when
        Client sut = new Client(dummyStubId, dummyClientName);
        //endregion

        //region then
        assertThat(sut.getId(), equalTo(dummyStubId));
        assertThat(sut.getName(), equalTo(dummyClientName));
        //endregion
    }

    @Test(expected = IllegalArgumentException.class)
    public void raiseExceptionWhenCreatedWithNullId() {
        //region when
        Client sut = new Client(null, dummyClientName);
        //endregion
    }

    @Test(expected = IllegalArgumentException.class)
    public void raiseExceptionWhenCreatedWithEmptyName() {
        //region when
        Client sut = new Client(dummyStubId, "");
        //endregion
    }

    @Test(expected = IllegalArgumentException.class)
    public void raiseExceptionWhenCreatedWithNullName() {
        //region when
        Client sut = new Client(dummyStubId, null);
        //endregion
    }
}
