package com.example.demo.Services;

import com.example.demo.DTO.AccountDto;
import com.example.demo.Mapper.AccountMapper;
import com.example.demo.Model.Account;
import com.example.demo.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImp implements AccountService{

    private AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account=AccountMapper.mapToaccount(accountDto);
        Account accountsave=accountRepository.save(account);
        return AccountMapper.mapToaccountDto(accountsave);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account= accountRepository.findById(id)
                 .orElseThrow(()->new RuntimeException("account details not available"));
        return AccountMapper.mapToaccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account>accountlist=accountRepository.findAll();

        return accountlist.stream()
                .map((account -> AccountMapper.mapToaccountDto(account)))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto deposite(Long id, double amount) {
        Account account=accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account is not present"));

        double total=account.getAccount_balance()+amount;
        account.setAccount_balance(total);
        Account account1 =accountRepository.save(account);
        return AccountMapper.mapToaccountDto(account1);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account=accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account is not present"));

        if(account.getAccount_balance()<amount)
        {
            throw new RuntimeException("insufficient balance");
        }
        double total=account.getAccount_balance()-amount;
        account.setAccount_balance(total);
        Account account1= accountRepository.save(account);
        return AccountMapper.mapToaccountDto(account1);
    }

}
