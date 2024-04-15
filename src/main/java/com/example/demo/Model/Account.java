package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long account_id;
    @Column(name = "account_name")
    private String account_name;
    @Column(name = "account_number")
    private long account_number;
    @Column(name = "account_balance")
    private double account_balance;

}
