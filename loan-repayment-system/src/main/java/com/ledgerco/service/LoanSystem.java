package com.ledgerco.service;

import com.ledgerco.model.BalanceResponse;
import com.ledgerco.model.LoanDetails;

import java.util.HashMap;
import java.util.Map;

public class LoanSystem {
    private static final Map<String, LoanAccount> loans = new HashMap<>();

    public static void processLoan(String bankName, String borrowerName, int principal, int years, double rate) {
        LoanDetails loanDetails = new LoanDetails(bankName, borrowerName, principal, years, rate);
        loans.put(bankName + "_" + borrowerName, new LoanAccount(loanDetails));
    }

    public static void processLumpSumPayment(String bankName, String borrowerName, int amount, int emiNo) {
        LoanAccount loan = loans.get(bankName + "_" + borrowerName);
        if (loan != null) loan.makeLumpSumPayment(emiNo, amount);
    }

    public static void processBalance(String bankName, String borrowerName, int emiNo) {
        LoanAccount loan = loans.get(bankName + "_" + borrowerName);
        if (loan != null) {
            BalanceResponse balanceResponse = loan.getBalance(emiNo);
            System.out.println(balanceResponse.bankName() + " " + balanceResponse.borrowerName() + " " + balanceResponse.totalPaid() + " " + balanceResponse.remainingEMIs());
        };
    }
}
