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

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server Listening on port " + port);
        return serverSocket;
    }

    @Override
    public Socket connectToClient(ServerSocket socket)
            throws IOException {
        try {

            clientSocket = socket.accept();
            System.out.println("Client Connected");
            createIOStream();
        } catch (IOException e) {
            System.out.println("Connection not successful");
        }
        return clientSocket;
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

    public void createIOStream() throws IOException {
        input = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        output = new PrintWriter(clientSocket.getOutputStream(), true);
    }
}
