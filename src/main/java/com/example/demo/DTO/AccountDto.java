package com.example.demo.DTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private long account_id;
    private String account_name;
    private long account_number;
    private double account_balance;
}
