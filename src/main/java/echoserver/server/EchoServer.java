package echoserver.server;

import java.io.IOException;
import java.net.ServerSocket;


public class EchoServer {
    private ServerSocketInterface socketWrapper;

    public EchoServer(ServerSocketInterface socket) {
        this.socketWrapper = socket;
    }

    public void run(int portNumber) {
        try {
            ServerSocket serverSocket =
                    socketWrapper.createServerSocket(portNumber);
            socketWrapper.connectToClient(serverSocket);

            String clientMessage;
            while ((clientMessage = socketWrapper.receiveData()) != null) {
                socketWrapper.sendData(clientMessage);
            }
            socketWrapper.close();
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
