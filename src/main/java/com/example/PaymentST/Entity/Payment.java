package com.example.PaymentST.Entity;

import com.example.PaymentST.enums.Currency;
import com.example.PaymentST.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int amount;
    @Enumerated(value = STRING)
    private Currency currency;
    private String code;
    @Enumerated(value = STRING)
    private State state;
    private String namePayment;

}
