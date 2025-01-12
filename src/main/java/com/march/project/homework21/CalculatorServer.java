package com.march.project.homework21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
    private ServerSocket serverSocket;
    private static int port = 5555;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server listening on port: " + serverSocket.getLocalPort());

            while (true) {
                new CalculatorServer.EchoClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            stop();
        }
    }

    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class EchoClientHandler extends Thread {
        private final Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public EchoClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            System.out.println("Client connected to address: " + clientSocket.getInetAddress());
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if ("q".equals(inputLine)) {
                        out.println("bye");
                        close();
                        break;
                    }
                    String resultExpression = calculateExpression(inputLine);
                    out.println(resultExpression);
                }
                close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        private String calculateExpression(String msg) {
            String[] expressionArr = msg.split(" ");
            String result;

            try {
                switch (expressionArr[2]) {
                    case "+" -> result = Integer.toString(Integer.parseInt(expressionArr[0]) + Integer.parseInt(expressionArr[1]));
                    case "-" -> result = Integer.toString(Integer.parseInt(expressionArr[0]) - Integer.parseInt(expressionArr[1]));
                    case "*" -> result = Integer.toString(Integer.parseInt(expressionArr[0]) * Integer.parseInt(expressionArr[1]));
                    case "/" -> result = Integer.toString(Integer.parseInt(expressionArr[0]) / Integer.parseInt(expressionArr[1]));
                    default -> result = "Incorrect operation";
                }
            } catch (NumberFormatException e) {
                result = e.getMessage();
                System.err.println(e.getMessage());
            }
            return result;
        }

        public void close() throws IOException {
            in.close();
            out.close();
            clientSocket.close();
            System.out.println("Клиент отключился.");
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(port);
        port = s.getLocalPort();
        s.close();

        CalculatorServer calculatorServer = new CalculatorServer();
        calculatorServer.start(port);
    }
}
