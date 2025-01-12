package com.march.project.core_networking.sync_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println(serverSocket.getLocalPort());
            clientSocket = serverSocket.accept();

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader((new InputStreamReader(clientSocket.getInputStream())));

            String greeting = in.readLine();
            System.out.println(greeting);
            if ("hello".equals(greeting)) {
                out.println("Hello client");
            } else {
                out.println("incorrect request");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        GreetServer greetServer = new GreetServer();
        greetServer.start(8080);
    }
}
