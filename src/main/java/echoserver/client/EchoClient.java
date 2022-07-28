package echoserver.client;

import java.io.*;
import java.net.*;


public class EchoClient {
    private ClientSocketInterface clientSocket;

    public EchoClient(ClientSocketInterface socket){
        this.clientSocket =  socket;
    }

    public void start(InetAddress hostName, int portNumber)  {
        try
         {
             clientSocket.create(hostName, portNumber);
            String userInput;
            while ((userInput = clientSocket.getInput()) != null) {
                clientSocket.sendMessage(userInput);
                clientSocket.receiveMessage();
            }
            clientSocket.close();
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}
