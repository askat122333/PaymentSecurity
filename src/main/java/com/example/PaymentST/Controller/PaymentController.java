package com.example.PaymentST.Controller;

import com.example.PaymentST.Dto.PaymentDto;
import com.example.PaymentST.Entity.Payment;
import com.example.PaymentST.enums.State;
import com.example.PaymentST.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @GetMapping("/{id}")
    public PaymentDto getPayment (@PathVariable Long id) {
        return paymentService.getById(id);
    }
    @GetMapping("/all")
    public List<PaymentDto> getAll() {
        return paymentService.getAll();
    }
    @PostMapping("/make")
    public Payment makePayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.makePayment(paymentDto);
    }
    @GetMapping("/delete/{id}")
    public String deletePayment( @PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Payment delete";
    }
    @PutMapping("/update")
    public Payment updatePayment(@RequestBody PaymentDto paymentDto){
        return paymentService.updatePayment(paymentDto);
    }
    @GetMapping("/currency/{currency}")
    public Integer getAllByCurrency(@PathVariable Currency currency) {
     return    paymentService.getAllByCurrency(currency);
    }
    @GetMapping("/name/{namePayment}")
    public List<PaymentDto> findByNamePayment(@PathVariable String namePayment) {
        return paymentService.findByNamePayment(namePayment);
    }
    @GetMapping("/state/{state}")
    public List<PaymentDto> findByState (@PathVariable State state) {
        return paymentService.findByState(state);
    }

}
