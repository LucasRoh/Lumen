package net.ictcampus.lumen_backend.web.rest;


import lombok.RequiredArgsConstructor;
import net.ictcampus.lumen_backend.entities.Account;
import net.ictcampus.lumen_backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;


    @Autowired
    public AccountController(AccountService accountService) {this.accountService = accountService;}

    @GetMapping
    public List<Account> getAccounts() {
        try {
            return accountService.getAllAccounts();
        }
        catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }



    @GetMapping(path = "{id}")
    public Account getAccount(@PathVariable Integer id) {
        try {
            return accountService.getAccountById(id);
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void postAccount(@Valid @RequestBody Account account) {
        try{
            accountService.createAccount(account);
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping
    public void updateAccount(@Valid @RequestBody Account account) {
        try {
            accountService.updateAccount(account);
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public void deleteAccountByID(Integer id) {
        try {
            accountService.deleteAccountById(id);
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



}
