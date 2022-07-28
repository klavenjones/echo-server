package echoserver;
import echoserver.client.EchoClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EchoClientTest {
    @Test
    @DisplayName("Test if connection was created and if data was echoed back.")
    public void testSendingDataAndEchoedData() throws UnknownHostException {
        InetAddress host = InetAddress.getByName("localhost");
        BufferedReader input = new BufferedReader(new StringReader("ECHO THIS"));
        PrintWriter output = new PrintWriter(new StringWriter(), true);
        MockClientSocket socket = new
                MockClientSocket(output, input);

        EchoClient echoClient = new EchoClient(socket);
        echoClient.start(host, 8080);

        assertTrue(socket.wasCreateCalled());
        assertEquals("ECHO THIS", socket.receiveMessage());
    }


    @Test
    @DisplayName("Test if connection was closed.")
    public void testIfConnectionWasClosed() throws UnknownHostException {
        InetAddress host = InetAddress.getByName("localhost");
        BufferedReader input = new BufferedReader(new StringReader("ECHO THIS"));
        PrintWriter output = new PrintWriter(new StringWriter(), true);
        MockClientSocket socket = new
                MockClientSocket(output, input);

        EchoClient echoClient = new EchoClient(socket);
        echoClient.start(host, 8080);

        assertTrue(socket.wasCreateCalled());
        assertTrue(socket.wasConnectionClosed());
    }



}
