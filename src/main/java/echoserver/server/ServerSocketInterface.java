package echoserver.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public interface ServerSocketInterface {
    ServerSocket createServerSocket(int port) throws IOException;
    Socket connectToClient(ServerSocket socket) throws IOException;
    String receiveData();
    void sendData(String message);
    void close() throws IOException;
}
