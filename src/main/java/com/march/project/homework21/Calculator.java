package com.march.project.homework21;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    private static final int PORT = 5555;

    public static void main(String[] args) {
        CalculatorClient calculatorClient = connectedToCalculatorServer("127.0.0.1", PORT);

        System.out.println();
        System.out.println("*** Enter two numbers separated by spaces and the type of operation: +, -, *, /");
        System.out.println("* To exit, enter q");

        while(true) {
            Scanner scanner = new Scanner(System.in);
            String expressionFromUser = scanner.nextLine();

            String resultFromServer = sendCalculationExpressionToServer(calculatorClient, expressionFromUser);

            if (Objects.equals(resultFromServer, "bye")) {
                System.out.println("End of communication.");
                stopCalculatorClient(calculatorClient);
                break;
            }
            System.out.println(resultFromServer);
        }
    }

    private static CalculatorClient connectedToCalculatorServer(String ip, int port) {
        CalculatorClient calculatorClient = new CalculatorClient();

        try {
            calculatorClient.startConnection(ip, port);
        } catch (IOException e) {
            System.err.println("Connection refused.");
            System.exit(0);
        }
        return calculatorClient;
    }

    private static String sendCalculationExpressionToServer(CalculatorClient calculatorClient, String expression) {
        String msgAnswer = null;

        try {
            msgAnswer = calculatorClient.sendMessage(expression);
        } catch (IOException e) {
            System.out.println("Connection refused");
            System.exit(0);
        }
        return msgAnswer;
    }

    private static void stopCalculatorClient(CalculatorClient calculatorClient) {
        try{
            calculatorClient.stopConnection();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
