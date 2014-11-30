package whiteship.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void getterSetter() {
        Account account = new Account();
        String email = "whiteship@email.com";
        account.setEmail(email);
        assertThat(account.getEmail(), is(email));
    }

}