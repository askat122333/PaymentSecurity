package com.example.PaymentST.service;

import com.example.PaymentST.Dto.PaymentDto;
import com.example.PaymentST.Entity.Payment;
import com.example.PaymentST.Repository.PaymentRepository;
import com.example.PaymentST.enums.State;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    public PaymentDto getById (Long id) {
       return  makeToDto(paymentRepository.findById(id).get());
    }
    public List<PaymentDto> getAll () {
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentDto> paymentDtos = new ArrayList<>();
        for (Payment payment:payments) {
            PaymentDto paymentDto = makeToDto(payment);
            paymentDtos.add(paymentDto);
        }
        return paymentDtos;
    }
    public Payment makePayment (PaymentDto paymentDto ) {
        makeToEntity(paymentDto);
        paymentDto.setCode( makePaymentGeneration());
        return paymentRepository.save(makeToEntity(paymentDto));
    }
    public void deletePayment ( Long id) {
        paymentRepository.deleteById(id);
    }
    public Payment updatePayment (PaymentDto paymentDto) {
     Payment payment = paymentRepository.findById(paymentDto.getId()).get();

     if (payment.getAmount() == 0) payment.setAmount(paymentDto.getAmount());
     if (payment.getCode() == null) payment.setCode(paymentDto.getCode());
     if(payment.getState() == null) payment.setState(paymentDto.getState());
     if(payment.getCurrency() == null) payment.setCurrency(paymentDto.getCurrency());
     if(payment.getNamePayment() == null) payment.setNamePayment(paymentDto.getNamePayment());
       return paymentRepository.save(payment);
    }
    public String makePaymentGeneration() {
        int length = 12;
        Random r = new Random();
        String s = r.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i) .limit(length) .collect
                        (StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return s;
    }
    public PaymentDto makeToDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(payment.getId());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setCurrency(payment.getCurrency());
        paymentDto.setCode(payment.getCode());
        paymentDto.setState(payment.getState());
        return paymentDto;
    }
    public Payment makeToEntity(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setId(paymentDto.getId());
        payment.setAmount(paymentDto.getAmount());
        payment.setCurrency(paymentDto.getCurrency());
        payment.setCode(paymentDto.getCode());
        payment.setState(paymentDto.getState());
        return payment;
    }


public Integer getAllByCurrency(Currency currency) {
     return    paymentRepository.getAllByCurrency(currency);
}

public List<PaymentDto> findByNamePayment(String namePayment) {
  List<PaymentDto> paymentDtos = paymentRepository.findByNamePayment(namePayment);
  return paymentDtos;
}
public List<PaymentDto> findByState (State state) {
        List<PaymentDto> paymentDtos = paymentRepository.findByState(state);
        return paymentDtos;
}

}
