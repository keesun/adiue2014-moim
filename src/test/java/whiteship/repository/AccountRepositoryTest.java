package whiteship.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import whiteship.Application;
import whiteship.domain.Account;

import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@Transactional
public class AccountRepositoryTest {

    @Autowired AccountRepository accountRepository;

    @Test
    public void crud() {
        // given
        Account account = new Account();
        account.setEmail("whiteship@email.com");
        account.setUsername("whtieship");
        account.setPassword("password");

        // when
        accountRepository.save(account);

        // then
        assertThat(accountRepository.findAll().size(), is(1));
    }

}