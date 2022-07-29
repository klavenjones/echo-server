package echoserver;

import echoserver.server.ServerSocketInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerSocketMock implements ServerSocketInterface {

    public boolean connectionClosed = false;
    public boolean serverCreated = false;
    public boolean connectedToClient = false;

    public BufferedReader reader;
    public PrintWriter writer;
    public String dataSent;


    public ServerSocketMock(BufferedReader input, PrintWriter output) {
        this.reader = input;
        this.writer = output;
    }


    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        serverCreated = true;
        return null;
    }

    @Override
    public Socket connectToClient(ServerSocket socket) throws IOException {
        connectedToClient = true;
        return null;
    }

    @Override
    public String receiveData() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error with Input");
        }
        return null;
    }

    @Override
    public void sendData(String message) {
        writer.write(message);
        dataSent = message;
    }

    @Override
    public void close() throws IOException {
        connectionClosed = true;
    }

    public boolean isConnectionClosed() {
        return connectionClosed;
    }

    public boolean isServerCreated() {
        return serverCreated;
    }

    public boolean isConnectedToClient() {
        return connectedToClient;
    }


}
