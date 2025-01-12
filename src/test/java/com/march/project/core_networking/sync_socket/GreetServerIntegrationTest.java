package com.march.project.core_networking.sync_socket;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

public class GreetServerIntegrationTest {
    private GreetClient client;
    private static int port;

    @BeforeClass
    public static void start() throws IOException, InterruptedException {
        // Take an available port
        ServerSocket s = new ServerSocket(0);
        port = s.getLocalPort();
        s.close();

        Executors.newSingleThreadExecutor().submit(() -> new GreetServer().start(port));
        Thread.sleep(2000);
    }

    @Before
    public void init() {
        client = new GreetClient();
        client.startConnection("127.0.0.1", port);
    }

    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() {
        String response = client.sendMessage("hello");
        assertEquals("Hello client", response);
    }

    @After
    public void finish() {
        client.stopConnection();
    }
}
