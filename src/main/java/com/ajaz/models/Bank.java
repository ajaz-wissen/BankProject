package com.ajaz.models;

import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bank {
    private Long id;
    private String name;
    private String address;
    @Lazy
    private List<Account> accounts;
}
