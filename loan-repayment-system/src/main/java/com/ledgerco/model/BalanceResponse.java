package com.ledgerco.model;


public record BalanceResponse (
    String bankName,
    String borrowerName,
    int totalPaid,
    int remainingEMIs){

}
