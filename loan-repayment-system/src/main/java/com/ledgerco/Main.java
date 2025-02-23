package com.ledgerco;

import com.ledgerco.service.processor.CommandProcessor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandProcessor processor = new CommandProcessor();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("EXIT")) {
                break;
            }
            processor.process(command);
        }
        scanner.close();
    }
}