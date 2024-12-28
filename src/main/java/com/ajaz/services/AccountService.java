package com.ajaz.services;

import com.ajaz.exceptions.AccountNotFoundException;
import com.ajaz.models.Account;

public interface AccountService {
    Account getAccountDetailsById(Long id) throws AccountNotFoundException;
    Account createAccountDetails(Account account);
    Account getAccountDetailsByAccountNumber(String accountNumber) throws AccountNotFoundException;
    Account updateAccountByAccountNumber(String accountNumber, Account account);
}
