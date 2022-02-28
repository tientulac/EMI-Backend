package com.components.backend.services;

import com.components.backend.models.Loan;

import java.util.List;

public interface LoanService {
    List<Loan> findAll();
    List<Loan> findByCustomer(int customer_id);
    Loan insertOne(Loan loan);
    double calculate(double amount, int tenure, double rate);
}
