package com.march.project.core_networking.echo_socket;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

public class EchoIntegrationTest {
    private static int port;
    private EchoClient client;

    @BeforeClass
    public static void start() throws IOException, InterruptedException {
        // Take is available port
        ServerSocket s = new ServerSocket(0);
        port = s.getLocalPort();
        s.close();

        Executors.newSingleThreadExecutor().submit(() -> new EchoServer().start(port));
        Thread.sleep(2000);
    }

    @Before
    public void init() {
        client = new EchoClient();
        client.startConnection("127.0.0.1", port);
    }

    @Test
    public void givenEchoClient_whenServerEchosMessage_thenCorrect() {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("word");
        String resp3 = client.sendMessage("!");
        String resp4 = client.sendMessage(".");

        assertEquals("hello", resp1);
        assertEquals("word", resp2);
        assertEquals("!", resp3);
        assertEquals("good bye", resp4);
    }

    @After
    public void finish() {
        client.stopConnection();
    }
}
