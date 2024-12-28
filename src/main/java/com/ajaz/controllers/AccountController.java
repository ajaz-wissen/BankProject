package com.ajaz.controllers;

import com.ajaz.exceptions.AccountNotFoundException;
import com.ajaz.models.Account;
import com.ajaz.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService){

        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccountDetails(@RequestBody Account account){
        Account createdAccount =  accountService.createAccountDetails(account);

        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountDetailsById(@PathVariable("id") Long id) throws AccountNotFoundException {
//        System.out.println("coming...");
        Account response = accountService.getAccountDetailsById(id);
//        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/accountNumber/{accountNumber}")
    public ResponseEntity<Account> getAccountDetailsByAccountNumber(@PathVariable("accountNumber") String accountNumber) throws AccountNotFoundException {

        Account response = accountService.getAccountDetailsByAccountNumber(accountNumber);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/accountNumber/{accountNumber}")
    public ResponseEntity<Account> updateAccountByAccountNumber(@PathVariable("accountNumber") String accountNumber, @RequestBody Account account){
        return ResponseEntity.ok(accountService.updateAccountByAccountNumber(accountNumber, account));
    }
}
