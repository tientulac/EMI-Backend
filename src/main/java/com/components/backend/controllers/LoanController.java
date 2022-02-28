package com.components.backend.controllers;

import com.components.backend.models.Customer;
import com.components.backend.models.Loan;
import com.components.backend.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/loan") // router
public class LoanController {
    @Autowired
    LoanService loanService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Loan> getList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {
        List<Loan> listLoan = loanService.findAll();
        return listLoan;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{customer_id}")
    public List<Loan> getListByCustomerId(@RequestParam int customer_id) {
        List<Loan> listLoan = loanService.findByCustomer(customer_id);
        return listLoan;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Loan insert(@RequestBody Loan loan) {
        return loanService.insertOne(loan);
    }

    @RequestMapping(method = RequestMethod.POST, path = "calculate")
    public Double calculateLoan(@RequestBody Loan loan) {
        double result = loanService.calculate(loan.getAmount(), loan.getTenure(), loan.getRate());
        return result;
    }
}
