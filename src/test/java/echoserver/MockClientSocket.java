package echoserver;

import echoserver.client.ClientSocketInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

public class MockClientSocket implements ClientSocketInterface {

    private PrintWriter output;
    private BufferedReader input;
    private String dataSent;
    private boolean connectionClosed = false;
    private boolean createCalled = false;

    public MockClientSocket(PrintWriter output, BufferedReader input) {
        this.output = output;
        this.input = input;
    }


    @Override
    public void create(InetAddress address, int portNumber) throws IOException {
        createCalled = true;
    }

    @Override
    public String getInput() throws IOException {
        try {
            return input.readLine();
        } catch (IOException e) {
            System.err.print("Error reading user input.");
        }
        return null;
    }

    @Override
    public void sendMessage(String message) {
        output.println(message);
        dataSent = message;
    }

    @Override
    public String receiveMessage() {
        return dataSent;
    }

    @Override
    public void close() throws IOException {
        connectionClosed = true;
    }

    public boolean wasConnectionClosed() {
        return connectionClosed;
    }

    public boolean wasCreateCalled() {
        return createCalled;
    }
}
