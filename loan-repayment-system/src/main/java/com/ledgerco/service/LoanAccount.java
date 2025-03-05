package com.ledgerco.service;
import com.ledgerco.model.*;

public class LoanAccount {
    private final LoanDetails loanDetails;
    private final LumpSumPayments lumpSumPayments;
    private final EMIPayments emiPayments;

    public LoanAccount(LoanDetails loanDetails) {
        this.loanDetails = loanDetails;
        this.lumpSumPayments = new LumpSumPayments();
        this.emiPayments = new EMIPayments(loanDetails.emiAmount);
    }

    public void makeLumpSumPayment(int emiNo, int amount) {
        lumpSumPayments.addPayment(emiNo, amount);
    }

    public BalanceResponse getBalance(int emiNo) {
        int totalEMIPaid = emiPayments.getTotalPaidThroughEMIs(emiNo);
        int totalLumpSumPaid = lumpSumPayments.getTotalLumpSumPaidUpTo(emiNo);
        int totalPaid = totalEMIPaid + totalLumpSumPaid;
        int remainingAmount = Math.max(0, loanDetails.totalAmount - totalPaid);
        int remainingEMIs = (int) Math.ceil((double) remainingAmount / loanDetails.emiAmount);
        return new BalanceResponse(loanDetails.bankName, loanDetails.borrowerName, totalPaid, remainingEMIs);
    }
}
