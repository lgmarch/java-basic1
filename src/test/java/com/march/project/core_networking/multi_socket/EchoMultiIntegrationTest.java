package com.march.project.core_networking.multi_socket;

import com.march.project.core_networking.echo_socket.EchoClient;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

public class EchoMultiIntegrationTest {
    private static int port;

    @BeforeClass
    public static void start() throws InterruptedException, IOException {

        // Take an available port
        ServerSocket s = new ServerSocket(0);
        port = s.getLocalPort();
        s.close();

        Executors.newSingleThreadExecutor().submit(() -> new EchoMultiServer().start(port));
        Thread.sleep(2000);
    }

    @Test
    public void givenClient1_whenServerResponds_thenCorrect() {
        EchoClient client = new EchoClient();
        client.startConnection("127.0.0.1", port);
        String msg1 = client.sendMessage("hello");
        String msg2 = client.sendMessage("world");
        String terminate = client.sendMessage(".");

        assertEquals(msg1, "hello");
        assertEquals(msg2, "world");
        assertEquals(terminate, "bye");
        client.stopConnection();
    }

    @Test
    public void givenClient2_whenServerResponds_thenCorrect() {
        EchoClient client = new EchoClient();
        client.startConnection("127.0.0.1", port);
        String msg1 = client.sendMessage("hello");
        String msg2 = client.sendMessage("world");
        String terminate = client.sendMessage(".");
        assertEquals(msg1, "hello");
        assertEquals(msg2, "world");
        assertEquals(terminate, "bye");
        client.stopConnection();
    }
}
