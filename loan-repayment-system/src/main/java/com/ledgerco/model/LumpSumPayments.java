package com.ledgerco.model;
import java.util.HashMap;
import java.util.Map;

public class LumpSumPayments {
    private final Map<Integer, Integer> payments = new HashMap<>();

    public void addPayment(int emiNo, int amount) {
        payments.put(emiNo, payments.getOrDefault(emiNo, 0) + amount);
    }

    public int getTotalLumpSumPaidUpTo(int emiNo) {
        return payments.entrySet().stream().filter(e -> e.getKey() <= emiNo).mapToInt(Map.Entry::getValue).sum();
    }
}
