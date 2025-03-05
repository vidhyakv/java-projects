package com.ledgerco.service;

import com.ledgerco.enums.CommandType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanSystemTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    LoanSystem loanSystem;

    @BeforeEach
    void setUpStreams() {
        loanSystem = new LoanSystem();
        System.setOut(new PrintStream(outContent)); // Redirect System.out
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut); // Restore System.out
    }

    @Test
    void performLoanProcessing() {


        loanSystem.processLoan("IDIDI", "Dale", 10000, 5, 4);
        loanSystem.processLoan("MBI", "Harry", 2000, 2, 2);
        loanSystem.processBalance("IDIDI","Dale",5);
        loanSystem.processBalance("IDIDI","Dale",40);
        loanSystem.processBalance("MBI","Harry",12);
        loanSystem.processBalance("MBI","Harry",0);
        assertEquals("IDIDI Dale 1000 55\n" +
                "IDIDI Dale 8000 20\n" +
                "MBI Harry 1044 12\nMBI Harry 0 24", outContent.toString().trim());
    }

    @Test
    void testMultipleLumpSumPayments() {
        loanSystem.processLoan("IDIDI", "Dale", 5000, 1, 6);
        loanSystem.processLumpSumPayment("IDIDI","Dale",1000, 5);
        loanSystem.processBalance("IDIDI", "Dale", 6);
        assertEquals("IDIDI Dale 3652 4",outContent.toString().trim());
    }

}
