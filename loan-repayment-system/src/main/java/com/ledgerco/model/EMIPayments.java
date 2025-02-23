package com.ledgerco.model;

public class EMIPayments {
    private final int emiAmount;

    public EMIPayments(int emiAmount) {
        this.emiAmount = emiAmount;
    }

    public int getTotalPaidThroughEMIs(int emiNo) {
        return emiNo * emiAmount;
    }
}
