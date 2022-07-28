package echoserver.client;

import java.io.IOException;
import java.net.InetAddress;

public interface ClientSocketInterface {
    void create(InetAddress address, int portNumber) throws IOException;
    String getInput() throws IOException;
    void sendMessage(String message);
    String receiveMessage();
    void close() throws IOException;
}
