package echoserver.server;

import java.io.IOException;


public interface ServerSocketInterface {
    String receiveData();
    void sendData(String message);
    void close() throws IOException;
}
