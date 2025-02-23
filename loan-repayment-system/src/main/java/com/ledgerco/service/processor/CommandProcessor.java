package com.ledgerco.service.processor;

import com.ledgerco.enums.CommandType;
import com.ledgerco.service.LoanSystem;

public class CommandProcessor {

    LoanSystem loanSystem = new LoanSystem();
    public void process(String command) {
        String[] parts = command.split(" ");
        CommandType commandType;

        try {
            commandType = CommandType.fromString(parts[0]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        switch (commandType) {
            case LOAN -> processLoan(parts);
            case PAYMENT -> processPayment(parts);
            case BALANCE -> processBalance(parts);
        }
    }

    private void processLoan(String[] parts) {
        String bank = parts[1];
        String borrower = parts[2];
        int principal = Integer.parseInt(parts[3]);
        int years = Integer.parseInt(parts[4]);
        double rate = Double.parseDouble(parts[5]);

        loanSystem.processLoan(bank, borrower, principal, years, rate);
    }

    private void processPayment(String[] parts) {
        String bank = parts[1];
        String borrower = parts[2];
        int amount = Integer.parseInt(parts[3]);
        int emiNo = Integer.parseInt(parts[4]);

        loanSystem.processLumpSumPayment(bank,borrower,amount,emiNo);
    }

    private void processBalance(String[] parts) {
        String bank = parts[1];
        String borrower = parts[2];
        int emiNo = Integer.parseInt(parts[3]);

        loanSystem.processBalance(bank,borrower,emiNo);
    }
}
