package com.components.backend.repositories;

import com.components.backend.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
    @Query("SELECT l FROM Loan l WHERE l.customer_id = ?1")
    List<Loan> findLoanByCustomerId(int customer_id);
}
