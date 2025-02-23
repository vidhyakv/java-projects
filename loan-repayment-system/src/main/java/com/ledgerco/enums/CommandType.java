package com.ledgerco.enums;


public enum CommandType {
    LOAN,
    PAYMENT,
    BALANCE;

    public static CommandType fromString(String command) {
        try {
            return CommandType.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid command: " + command);
        }
    }
}
