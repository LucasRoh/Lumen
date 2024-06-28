package net.ictcampus.lumen_backend.web.rest;

import net.ictcampus.lumen_backend.entities.Account;
import net.ictcampus.lumen_backend.entities.Blog;
import net.ictcampus.lumen_backend.service.AccountService;
import net.ictcampus.lumen_backend.service.BlogService;
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
    private final BlogService blogService;


    @Autowired
    public AccountController(AccountService accountService, BlogService blogService) {this.accountService = accountService;
        this.blogService = blogService;
    }

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

    @GetMapping(path = "{id}/blogs")
    public Iterable<Blog> getBlogs(@PathVariable Integer id) {
        try {
            return accountService.getAccountById(id).getBlogs();
        }catch(EntityNotFoundException e){
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


    @PutMapping(path = "{accountId}/imagePath")
    public void setImagePath(@PathVariable Integer accountId, @RequestParam String imagePath) {
        try {
            accountService.setImagePath(accountId, imagePath);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to update image path!");
        }
    }



}
