package com.example.PaymentST.Repository;

import com.example.PaymentST.Dto.PaymentDto;
import com.example.PaymentST.Entity.Payment;
import com.example.PaymentST.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Currency;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
@Query(value = "SELECT sum(amount) from Payment where currency = ?",nativeQuery = true)
Integer getAllByCurrency (Currency currency);
List<PaymentDto> findByNamePayment(String namePayment);
List<PaymentDto> findByState(State state);

}
