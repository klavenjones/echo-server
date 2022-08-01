package echoserver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketWrapper implements ServerSocketInterface {

    ServerSocket serverSocket;
    Socket clientSocket;
    BufferedReader input;
    PrintWriter output;

    public ServerSocketWrapper(Socket socket) throws IOException {
        this.clientSocket = socket;
        this.input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        this.output = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public String receiveData() {
        try {
            String clientInput = input.readLine();
            System.out.println("From the Client " + clientInput);
            return clientInput;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void sendData(String message) {
        output.println(message);
    }

    @Override
    public void close() throws IOException {
        input.close();
        output.close();
        clientSocket.close();
        serverSocket.close();
    }

}
