package com.ledgerco.service;

import com.ledgerco.enums.CommandType;
import org.junit.jupiter.api.Test;

public class LoanSystemTest {

    @Test
    void performLoanProcessing() {

        LoanSystem loanSystem = new LoanSystem();

        loanSystem.processLoan("IDIDI", "Dale", 10000, 5, 4);
        loanSystem

    }
}
