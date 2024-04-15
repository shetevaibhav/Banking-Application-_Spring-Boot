package com.example.demo.Services;

import com.example.demo.DTO.AccountDto;
import com.example.demo.Model.Account;

import java.util.List;

public interface AccountService {

    AccountDto  createAccount(AccountDto accountDto);
    AccountDto  getAccountById(Long id);
    List<AccountDto> getAllAccount();
    AccountDto deposite(Long id,double amount);

    AccountDto withdraw(Long id,double amount);



}
