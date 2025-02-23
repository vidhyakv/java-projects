package com.ledgerco.service;

import com.ledgerco.model.LoanDetails;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanAccountTest {

    @Test
    void testLoanAccountCreation() {
        LoanDetails loan = new LoanDetails("IDIDI", "Dale", 10000, 5, 4);
        LoanAccount account = new LoanAccount(loan);

        assertEquals(12000, loan.totalAmount);
        assertEquals(200, loan.emiAmount);
    }

    @Test
    void testLumpSumPayment() {
        LoanDetails loan = new LoanDetails("IDIDI", "Dale", 5000, 2, 3);
        LoanAccount account = new LoanAccount(loan);

        account.makeLumpSumPayment(5, 1000);
        account.getBalance(5);
    }
}
