package whiteship.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import whiteship.domain.Account;
import whiteship.repository.AccountRepository;

/**
 * @author Keeun Baik
 */
@Service
public class AccountUserDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findByUsername(username);
        if(account == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AccountUserDetails(account);
    }
}
