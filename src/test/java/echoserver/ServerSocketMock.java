package echoserver;

import echoserver.server.ServerSocketInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


public class ServerSocketMock implements ServerSocketInterface {

    public boolean connectionClosed = false;
    public BufferedReader reader;
    public PrintWriter writer;
    public String dataSent;


    public ServerSocketMock(BufferedReader input, PrintWriter output) {
        this.reader = input;
        this.writer = output;
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
    public void close() {
        connectionClosed = true;
    }

    public boolean isConnectionClosed() {
        return connectionClosed;
    }


}
