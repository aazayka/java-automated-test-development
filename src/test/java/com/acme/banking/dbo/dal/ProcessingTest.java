package com.acme.banking.dbo.dal;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Cash;
import com.acme.banking.dbo.domain.SavingAccount;
import com.acme.banking.dbo.service.Processing;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ProcessingTest {

    @TestConfiguration
    static class ProcessingTestContextConfiguration {

        @Bean
        public Processing processing() {
            return new Processing();
        }
    }

    @Autowired
    private Processing sut;

    @MockBean
    private Cash cashMock;
    @MockBean
    private AccountRepository accountRepositoryStub;

    @MockBean(name = "accountMock1")
    private SavingAccount accountMock1;
    @MockBean(name = "accountMock2")
    private SavingAccount accountMock2;

    @Before
    public void setUp() {
        when(accountRepositoryStub.findAccountById(any(UUID.class)))
                .thenReturn(accountMock1)
                .thenReturn(accountMock2);
    }


    @Test
    public void shouldDepositAndWithdrawWhenTransfer() {

        sut.transfer(1., UUID.randomUUID(), UUID.randomUUID());

        verify(accountMock1, times(1)).withdraw(1.);
        verify(accountMock2).deposit(anyDouble());
    }

    @Test
    public void shouldLogWhenCash() {
        final UUID dummyAccountId = UUID.randomUUID();

        sut.cash(1., dummyAccountId);

        verify(cashMock).log(anyDouble(), eq(dummyAccountId));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenNullClientId() {
        sut.getAccountsByClientId(null);
    }

    @Test
    public void shouldGetAPleasureWhenTestIsGreen() {
        //region given
        //xUnit Patterns: dest-doublers
        //dummy
        //stub
        final UUID clientUuidStub = UUID.randomUUID();

        //Actually it's stub
        when(accountMock1.getAmount()).thenReturn(1.);
        when(accountMock2.getAmount()).thenReturn(2.);

        when(accountRepositoryStub.findAccountsByClientId(any(UUID.class)))
                .thenReturn(Collections.emptyList())
                .thenReturn(Arrays.asList(
                        accountMock1, accountMock2
                ));

        //region when
        final Collection<Account> accountsByClientId = sut.getAccountsByClientId(clientUuidStub);
        //endregion

        //region then
        assertThat(accountsByClientId).hasSize(0);
        accountsByClientId.forEach( a -> System.out.println(a.getId()));
        //endregionss
    }
}
