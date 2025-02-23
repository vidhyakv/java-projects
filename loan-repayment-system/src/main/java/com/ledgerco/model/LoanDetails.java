package com.ledgerco.model;

public class LoanDetails {
    public String bankName, borrowerName;
    public int principal, tenure, totalAmount, emiAmount, totalEMIs;
    public double rate;

    public LoanDetails(String bankName, String borrowerName, int principal, int tenure, double rate) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.tenure = tenure;
        this.rate = rate;
        this.totalAmount = calculateTotalAmount(principal, tenure, rate);
        this.totalEMIs = tenure * 12;
        this.emiAmount = (int) Math.ceil((double) totalAmount / totalEMIs);
    }

    private int calculateTotalAmount(int principal, int tenure, double rate) {
        return (int) Math.ceil(principal + (principal * tenure * rate) / 100);
    }
}
