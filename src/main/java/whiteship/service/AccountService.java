package whiteship.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import whiteship.controller.support.AccountDTO;
import whiteship.domain.Account;
import whiteship.repository.AccountRepository;

import java.util.Date;

/**
 * @author Keeun Baik
 */
@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Account createNew(AccountDTO.RequestToCreate accountDTO) {
        Account account = modelMapper.map(accountDTO, Account.class);
        account.setJoined(new Date());
        account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
        return repository.save(account);
    }
}
