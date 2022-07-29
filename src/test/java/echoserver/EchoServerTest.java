package echoserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import echoserver.server.EchoServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

public class EchoServerTest {
    @Test
    @DisplayName("Test whether the Socket was Created.")
    public void testIfSocketCreated() {
        PrintWriter writer = new PrintWriter(new StringWriter(), true);
        BufferedReader reader = new BufferedReader(new StringReader("Test"));
        ServerSocketMock socket = new ServerSocketMock(reader, writer);

        EchoServer echoServer = new EchoServer(socket);
        echoServer.run(8080);

        assertTrue(socket.isServerCreated());
    }

    @Test
    @DisplayName("Test to see if the server connected to client")
    public void testIfConnectedToClient() {
        PrintWriter writer = new PrintWriter(new StringWriter(), true);
        BufferedReader reader = new BufferedReader(new StringReader("Test"));
        ServerSocketMock socket = new ServerSocketMock(reader, writer);

        EchoServer echoServer = new EchoServer(socket);
        echoServer.run(8080);

        assertTrue(socket.isConnectedToClient());
    }

    @Test
    @DisplayName("Test to if the server sent the data")
    public void testIfSocketSentData() {
        PrintWriter writer = new PrintWriter(new StringWriter(), true);
        BufferedReader reader = new BufferedReader(new StringReader("Test"));
        ServerSocketMock socket = new ServerSocketMock(reader, writer);

        EchoServer echoServer = new EchoServer(socket);
        echoServer.run(8080);

        assertEquals(socket.dataSent, "Test");
    }


    @Test
    @DisplayName("Test to if the server sent the data")
    public void testIfSocketisClosed() {
        PrintWriter writer = new PrintWriter(new StringWriter(), true);
        BufferedReader reader = new BufferedReader(new StringReader("Test"));
        ServerSocketMock socket = new ServerSocketMock(reader, writer);

        EchoServer echoServer = new EchoServer(socket);
        echoServer.run(8080);

        assertTrue(socket.isConnectionClosed(), "Test");
    }
}
