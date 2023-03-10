package com.example.PaymentST.Dto;

import com.example.PaymentST.enums.Currency;
import com.example.PaymentST.enums.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {
    private Long id;
    private int amount;
    private Currency currency;
    private String code;
    private State state;
    private String namePayment;
}
