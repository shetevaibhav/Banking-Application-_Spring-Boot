package com.example.demo.Controller;

import com.example.demo.DTO.AccountDto;
import com.example.demo.Services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/account")
public class AccountController {

    private AccountService accountService;
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
         AccountDto saveaccountDto=accountService.createAccount(accountDto);
          return new ResponseEntity<>(saveaccountDto, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }
    @GetMapping
    public ResponseEntity<List<AccountDto>> getallAccount(){
        List<AccountDto>accountDtos=accountService.getAllAccount();
        return ResponseEntity.ok(accountDtos);
    }

    @PutMapping("/{id}/deposite")
    public ResponseEntity<AccountDto> deposite(@PathVariable Long id, @RequestBody Map<String,Double>request){
        Double amount=request.get("account_balance");
        AccountDto depositedto= accountService.deposite(id,amount);
        return ResponseEntity.ok(depositedto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double>request){
        Double amount=request.get("account_balance");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }
}
