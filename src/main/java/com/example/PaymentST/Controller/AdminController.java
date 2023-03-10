package com.example.PaymentST.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @GetMapping("/api/hello")
    public String hello(){
        return "Hello";
    }
}
