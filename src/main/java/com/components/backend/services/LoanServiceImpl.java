package com.components.backend.services;

import com.components.backend.models.Loan;
import com.components.backend.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{
    @Autowired
    LoanRepository loanRepository;

    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> findByCustomer(int customer_id) {
        return loanRepository.findLoanByCustomerId(customer_id);
    }

    @Override
    public Loan insertOne(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public double calculate(double amount, int tenure, double rate) {
        double _rate1 = Math.pow(1+rate,tenure);
        double _rate2 = Math.pow(1+rate,tenure-1);
        double result = 1*rate*(_rate1/_rate2)*1/12;
        return result;
    }
}
