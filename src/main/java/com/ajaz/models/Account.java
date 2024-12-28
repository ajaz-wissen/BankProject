package com.ajaz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Account {
    private Long id;
    private String accountNumber;
    private Bank bank;
    private Currency currency;
    private Long balance;
    private String branch;

    public Account(Long id, String accountNumber, Currency currency, Long balance, String branch){
        this.id = id;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = balance;
        this.branch = branch;
    }

}
