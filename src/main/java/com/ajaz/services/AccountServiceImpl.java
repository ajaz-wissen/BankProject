package com.ajaz.services;

import com.ajaz.exceptions.AccountNotFoundException;
import com.ajaz.models.Account;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Primary
public class AccountServiceImpl implements AccountService{
    Map<Long, Account> accountsById = new HashMap<>();
    Map<String, Account> accountsByNumber = new HashMap<>();

//    public void setDefaultAccounts(){
//        accounts.put(1L, new Account(1L, "12345", Currency.INR, "Gkp"));
//        accounts.put(2L, new Account(2L, "E1CV28", Currency.USD, "US BlockField"));
//        accounts.put(3L, new Account(3L, "89765", Currency.INR, "Bangalore"));
//    }

    @Override
    public Account createAccountDetails(Account account) {
        Long id = (long) accountsById.size() + 1;
        account.setId(id);
        accountsById.put(id, account);
        accountsByNumber.put(account.getAccountNumber(), account);

        return accountsById.get(id);
    }

    @Override
    public Account getAccountDetailsById(Long id) throws AccountNotFoundException{
        if(!accountsById.containsKey(id)) {
            throw new AccountNotFoundException("Account with id = " + id + " does not exist.");
        }

        return accountsById.get(id);
    }

    @Override
    public Account getAccountDetailsByAccountNumber(String accountNumber) throws AccountNotFoundException {
        if(!accountsByNumber.containsKey(accountNumber)) {
            throw new AccountNotFoundException("Account with account number = " + accountNumber + " does not exist.");
        }

        return accountsByNumber.get(accountNumber);
    }

    @Override
    public Account updateAccountByAccountNumber(String accountNumber, Account account) {
        Account savedAccount = accountsByNumber.get(accountNumber);

        savedAccount.setBalance(account.getBalance());

        accountsByNumber.put(accountNumber, savedAccount);

        return savedAccount;
    }
}
