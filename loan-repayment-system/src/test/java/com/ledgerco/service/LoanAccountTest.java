package com.ledgerco.service;

import com.ledgerco.model.BalanceResponse;
import com.ledgerco.model.LoanDetails;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanAccountTest {

    @Test
    void testLoanAccountCreation() {
        LoanDetails loan = new LoanDetails("IDIDI", "Dale", 10000, 5, 4);

        assertEquals(12000, loan.totalAmount);
        assertEquals(200, loan.emiAmount);
    }

    @Test
    void testLumpSumPayment() {

        LoanDetails loan = new LoanDetails("IDIDI", "Dale", 5000, 1, 6);
        LoanAccount account = new LoanAccount(loan);
        account.makeLumpSumPayment(5, 1000);

        BalanceResponse expectedBalanceResponse = new BalanceResponse("IDIDI","Dale",3652,4);

        BalanceResponse balanceResponse = account.getBalance(6);
        assertEquals(expectedBalanceResponse,balanceResponse);
    }
}
