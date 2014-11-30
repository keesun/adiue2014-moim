package whiteship.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import whiteship.controller.support.AccountDTO;
import whiteship.domain.Account;
import whiteship.repository.AccountRepository;
import whiteship.service.AccountService;

import javax.validation.Valid;

/**
 * @author Keeun Baik
 */
@Controller
public class AccountController {

    @Autowired
    AccountService service;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AccountRepository repository;

    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    public ResponseEntity createAccount(@RequestBody @Valid AccountDTO.RequestToCreate accountDTO,
                                        BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Account newAccount = service.createNew(accountDTO);
        return new ResponseEntity<>(modelMapper.map(newAccount, AccountDTO.Response.class), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/account/{username}", method = RequestMethod.GET)
    public ResponseEntity getAccount(@PathVariable String username) {
        Account account = repository.findByUsername(username);
        if(account != null) {
            return new ResponseEntity<>(modelMapper.map(account, AccountDTO.Response.class), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }



}
