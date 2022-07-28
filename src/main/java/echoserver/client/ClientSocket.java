package echoserver.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocket implements ClientSocketInterface {
    private PrintWriter output;
    private BufferedReader input;
    private BufferedReader userInput;
    private Socket socket;

    @Override
    public void create(InetAddress address, int portNumber) {
        try {
            socket = new Socket(address, portNumber);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public String getInput() throws IOException {
        userInput = new BufferedReader(new InputStreamReader(System.in));
        try {
            return userInput.readLine();
        } catch (IOException e){
           e.printStackTrace();
        }
        return null;
    }

    @Override
    public void sendMessage(String message) {
        output.println(message);
    }

    @Override
    public String receiveMessage() {
        try{
            String echo = input.readLine();
            System.out.println("Echo: " + echo);
            return echo;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        input.close();
        output.close();
        socket.close();
    }
}
