package com.example.demo.Mapper;

import com.example.demo.DTO.AccountDto;
import com.example.demo.Model.Account;

public class AccountMapper {
    public static Account mapToaccount(AccountDto accountDto){
        Account account=new Account(
             accountDto.getAccount_id(),
             accountDto.getAccount_name(),
             accountDto.getAccount_number(),
             accountDto.getAccount_balance()
        );
        return account;
    }


    public static AccountDto mapToaccountDto(Account account){
        AccountDto accountDto=new AccountDto(
                account.getAccount_id(),
                account.getAccount_name(),
                account.getAccount_number(),
                account.getAccount_balance()
        );
        return accountDto;
    }
}
