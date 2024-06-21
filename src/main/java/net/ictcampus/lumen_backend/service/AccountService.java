package net.ictcampus.lumen_backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.ictcampus.lumen_backend.entities.Account;
import net.ictcampus.lumen_backend.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account getAccountById(Integer id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        }
        log.info("Account user not found");
        return null;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public void createAccount(Account account) {
        Account savedAccount = accountRepository.save(account);
    }

    public void updateAccount(Account account) {

        if (accountRepository.existsById(account.getId_account())){
            Account updatedAccount = accountRepository.save(account);
        }
        else {throw new EntityNotFoundException();};


    }

    public void deleteAccount(Account account){
        accountRepository.delete(account);
    }

    public void deleteAccountById(Integer id) {
        Account deleteAccount = getAccountById(id);
        accountRepository.delete(deleteAccount);
    }


}
